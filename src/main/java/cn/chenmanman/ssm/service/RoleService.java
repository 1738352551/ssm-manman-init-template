package cn.chenmanman.ssm.service;

import cn.chenmanman.ssm.model.entity.Role;
import cn.chenmanman.ssm.model.entity.UserRole;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface RoleService {
    PageInfo queryRolePage(Integer pageNum, Integer pageSize, Role role);

    boolean updateRole(Role role);

    boolean saveRole(Role role);

    boolean removeRoleByIds(List<Long> ids);

    public List<Role> selectRolesByUserId(Long userId);


    /**
     * 取消授权用户角色
     *
     * @param userRole 用户和角色关联信息
     * @return 结果
     */
    public int deleteAuthUser(UserRole userRole);

    /**
     * 批量取消授权用户角色
     *
     * @param roleId 角色ID
     * @param userIds 需要取消授权的用户数据ID
     * @return 结果
     */
    public int deleteAuthUsers(Long roleId, Long[] userIds);

    /**
     * 批量选择授权用户角色
     *
     * @param roleId 角色ID
     * @param userIds 需要删除的用户数据ID
     * @return 结果
     */
    public int insertAuthUsers(Long roleId, Long[] userIds);


}
