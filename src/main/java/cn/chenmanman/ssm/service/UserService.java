package cn.chenmanman.ssm.service;


import cn.chenmanman.ssm.model.entity.User;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

public interface UserService {

    PageInfo<User> queryUserPage(Integer pageNum, Integer pageSize, User user);

    boolean addUser(User user);

    boolean removeUserByIds(List<Long> ids);

    User queryUserById(Long id);

    boolean updateUser(User user);


    Map<String,Object> login(String username, String password, String code, String uuid);


    void insertUserAuth(Long userId, Long[] roleIds);


}
