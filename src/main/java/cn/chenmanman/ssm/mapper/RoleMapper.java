package cn.chenmanman.ssm.mapper;

import cn.chenmanman.ssm.model.entity.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleMapper {
    

    /**
     * 条件查询角色
     * @author 陈慢慢
     * */
    List<Role> selectRoleList(Role role);


    /**
     * 根据id查找角色
     * */
    Role selectRoleById(Long id);



    /**
     * 添加新的角色
     * @author 陈慢慢
     * */
    boolean insertRole(Role role);

    /**
     * 更新角色信息
     * @author 陈慢慢
     * */
    boolean updateRole(Role role);

    /**
     * 批量删除角色根据id
     * @param ids id的集合
     * @author 陈慢慢
     * */
    boolean deleteRoleByIds(List<Long> ids);

    /**
     * 查询所有角色
     * @author 陈慢慢
     * */
    List<Role> selectRoleAll();


    /**
     * 查询用户所选的角色根据id
     *
     * */
    List<Role> selectRolePermissionByUserId(Long userId);

    /**
     * 查询用户所选的角色根据username
     *
     * */
    List<Role> selectRolesByUserName(String userName);


}
