package cn.chenmanman.ssm.service.impl;


import cn.chenmanman.ssm.common.ErrorCode;
import cn.chenmanman.ssm.exception.BusinessException;
import cn.chenmanman.ssm.mapper.UserMapper;
import cn.chenmanman.ssm.mapper.UserRoleMapper;
import cn.chenmanman.ssm.model.entity.User;
import cn.chenmanman.ssm.model.entity.UserRole;
import cn.chenmanman.ssm.service.UserService;
import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;


    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 分页查询
     * */
    @Override
    public PageInfo<User> queryUserPage(Integer pageNum, Integer pageSize, User user) {
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<User>(userMapper.selectUserList(user));
    }

    /**
     * 添加用户
     * */
    @Override
    public boolean addUser(User user) {
        if (Objects.isNull(user)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }

        User userById = userMapper.selectUserById(user.getId());
        if (Objects.nonNull(userById)){
            throw new BusinessException(5000, "用户已存在!");
        }

        return userMapper.insertUser(user);
    }

    /**
     * 批量删除id
     * */
    @Override
    public boolean removeUserByIds(List<Long> ids) {
        if (Objects.isNull(ids) || ids.size() == 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        boolean match = ids.stream().anyMatch(id -> userMapper.selectUserById(id) == null);
        if (match) {
            throw new BusinessException(5000, "不好意思, 这组用户可能存在已被删除或不存在的!");
        }
        return userMapper.deleteUserByIds(ids);
    }

    /**
     * 通过id查询用户信息
     * */
    @Override
    public User queryUserById(Long id) {
        if (Objects.isNull(id)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        return userMapper.selectUserById(id);
    }

    /**
     * 更新用户信息
     * */
    @Override
    public boolean updateUser(User user) {
        if (Objects.isNull(user)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        User userById = userMapper.selectUserById(user.getId());
        if (Objects.nonNull(userById)){
            throw new BusinessException(5000, "用户不存在!");
        }
        return userMapper.updateUser(user);
    }

    @Override
    public Map<String, Object> login(String username, String password, String code, String uuid) {

        String veCode = (String) redisTemplate.opsForValue().get("code:" + uuid);
        if (veCode==null) {
            throw new BusinessException(5000,"验证码失效!请重新获取");
        }
        if (!veCode.equals(code)){
            throw new BusinessException(5000,"验证码错误!");
        }

        // 校验用户是否存在!
        User userByUsername = userMapper.selectUserByUsername(username);
        if (Objects.isNull(userByUsername)){
            throw new BusinessException(5000, "用户名未找到!");
        }

        /**
         * 校验密码是否输入正确
         * todo: 账号加密
         * */
        if (!userByUsername.getPassword().equals(password)) {
            throw new BusinessException(5000, "密码不正确!");
        }

        // 签发令牌(token)
        DateTime nowTime = DateTime.now();

        // 过期时间
        DateTime expiresAt = nowTime.offsetNew(DateField.MINUTE, 30);

        String jwt = JWT.create()
                .setPayload("username", userByUsername.getUsername())
                .setKey("huanyuan".getBytes())
                .setExpiresAt(expiresAt)
                .setIssuedAt(nowTime)
                .sign();

        HashMap<String, Object> tokenMap = new HashMap<>();
        tokenMap.put("token", jwt);

        return tokenMap;
    }

    @Transactional
    @Override
    public void insertUserAuth(Long userId, Long[] roleIds) {
        userRoleMapper.deleteUserRoleByUserId(userId);
        insertUserRole(userId, roleIds);
    }

    public void insertUserRole(Long userId, Long[] roleIds)
    {
        if (roleIds!=null && roleIds.length>0)
        {
            // 新增用户与角色管理
            List<UserRole> list = new ArrayList<UserRole>(roleIds.length);
            for (Long roleId : roleIds)
            {
                UserRole ur = new UserRole();
                ur.setUserId(userId);
                ur.setRoleId(roleId);
                list.add(ur);
            }
            userRoleMapper.batchUserRole(list);
        }
    }
}
