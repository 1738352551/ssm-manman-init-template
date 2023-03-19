package cn.chenmanman.ssm.mapper;

import cn.chenmanman.ssm.model.entity.Menu;
import cn.chenmanman.ssm.model.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    User selectUserByUsername(String username);

    List<User> selectUserAll();

    List<User> selectUserList(User user);

    User selectUserById(Long id);

    boolean insertUser(User user);

    boolean updateUser(User user);

    boolean deleteUserByIds(List<Long> ids);


}
