package cn.chenmanman.ssm.service.impl;

import cn.chenmanman.ssm.exception.BusinessException;
import cn.chenmanman.ssm.mapper.RoleMapper;
import cn.chenmanman.ssm.mapper.RoleMenuMapper;
import cn.chenmanman.ssm.mapper.UserRoleMapper;
import cn.chenmanman.ssm.model.entity.Role;
import cn.chenmanman.ssm.model.entity.User;
import cn.chenmanman.ssm.model.entity.UserRole;
import cn.chenmanman.ssm.service.RoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private RoleMenuMapper roleMenuMapper;

    @Override
    public PageInfo queryRolePage(Integer pageNum, Integer pageSize, Role role) {
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo(roleMapper.selectRoleList(role));
    }

    @Override
    public boolean updateRole(Role role) {
        Role roleById = roleMapper.selectRoleById(role.getId());
        if (Objects.isNull(roleById)) {
            throw new BusinessException(5000, "角色不存在!");
        }
        return roleMapper.updateRole(role);
    }

    @Override
    public boolean saveRole(Role role) {

        Role roleById = roleMapper.selectRoleById(role.getId());
        if (Objects.nonNull(roleById)){
            throw new BusinessException(5000, "角色存在!");
        }

        return roleMapper.insertRole(role);
    }

    @Transactional
    @Override
    public boolean removeRoleByIds(List<Long> ids) {

        boolean match = ids.stream().anyMatch(id -> roleMapper.selectRoleById(id) == null);
        if (match) {
            throw new BusinessException(5000, "不好意思, 这组角色可能存在已被删除或不存在的!");
        }
        // 删除角色之前要先取消对应关联表中的关联
        for (Long id: ids) {
            Role role = roleMapper.selectRoleById(id);
            // 检查角色是否已经分配给用户
            if (userRoleMapper.countUserRoleByRoleId(id) > 0) {
                throw new BusinessException(5000, String.format("%1$s已分配,不能删除", role.getName()));
            }
        }
        // 没有分配就可以直接删除了
        roleMenuMapper.deleteRoleMenu(ids);
        return roleMapper.deleteRoleByIds(ids);
    }

    @Override
    public List<Role> selectRolesByUserId(Long userId) {
        List<Role> userRoles = roleMapper.selectRolePermissionByUserId(userId);
        return userRoles;
    }

    @Override
    public int deleteAuthUser(UserRole userRole) {
        return userRoleMapper.deleteUserRoleInfo(userRole);
    }

    @Override
    public int deleteAuthUsers(Long roleId, Long[] userIds) {
        return userRoleMapper.deleteUserRoleInfos(roleId, userIds);
    }

    @Override
    public int insertAuthUsers(Long roleId, Long[] userIds) {
        List<UserRole> list = new ArrayList<UserRole>();
        for (Long userId : userIds)
        {
            UserRole ur = new UserRole();
            ur.setUserId(userId);
            ur.setRoleId(roleId);
            list.add(ur);
        }
        return userRoleMapper.batchUserRole(list);
    }
}
