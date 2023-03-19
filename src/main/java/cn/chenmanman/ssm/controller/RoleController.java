package cn.chenmanman.ssm.controller;

import cn.chenmanman.ssm.common.BaseResponse;
import cn.chenmanman.ssm.common.ErrorCode;
import cn.chenmanman.ssm.common.ResultUtils;
import cn.chenmanman.ssm.exception.BusinessException;
import cn.chenmanman.ssm.model.dto.role.RoleAddRequest;
import cn.chenmanman.ssm.model.dto.role.RoleQueryRequest;
import cn.chenmanman.ssm.model.dto.role.RoleUpdateRequest;
import cn.chenmanman.ssm.model.entity.Menu;
import cn.chenmanman.ssm.model.entity.Role;
import cn.chenmanman.ssm.service.MenuService;
import cn.chenmanman.ssm.service.RoleService;
import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeNodeConfig;
import cn.hutool.core.lang.tree.TreeUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@Api(value = "角色管理", tags = {"角色管理"})
@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private MenuService menuService;


    @ApiOperation(value = "分页查询角色")
    @GetMapping
    public BaseResponse<?> findRolePage(@RequestBody RoleQueryRequest roleQueryRequest) {
        if (Objects.isNull(roleQueryRequest)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        Role role = new Role();
        BeanUtils.copyProperties(roleQueryRequest, role);
        return ResultUtils.success(roleService.queryRolePage(roleQueryRequest.getPageNum(), roleQueryRequest.getPageSize(), role));
    }

    @ApiOperation(value = "修改角色")
    @PutMapping
    public BaseResponse<?> modifyRole(@RequestBody RoleUpdateRequest roleUpdateRequest) {
        if (Objects.isNull(roleUpdateRequest)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        Role role = new Role();
        BeanUtils.copyProperties(roleUpdateRequest, role);

        return ResultUtils.success(roleService.updateRole(role));
    }


    @ApiOperation(value = "添加新角色")
    @PostMapping
    public BaseResponse<?> addRole(@RequestBody RoleAddRequest roleAddRequest) {
        if (Objects.isNull(roleAddRequest)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }

        Role role = new Role();
        BeanUtils.copyProperties(roleAddRequest, role);

        return ResultUtils.toResponse(roleService.saveRole(role));
    }

    @ApiOperation(value = "批量删除角色")
    @DeleteMapping
    public BaseResponse<?> deleteRoleByIds(List<Long> ids) {
        if (Objects.isNull(ids) || ids.size()<1) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }

        return ResultUtils.toResponse(roleService.removeRoleByIds(ids));
    }

    @ApiOperation("查角色可以操作的菜单username")
    @GetMapping("/menu/{roleId}")
    public BaseResponse getMenuByUsername(@PathVariable("roleId") Long roleId){
        if (roleId==null){
            throw new BusinessException(5000, "请填写角色id");
        }

        List<Menu> menus = menuService.queryMenuByRoleId(roleId);
        //配置
        TreeNodeConfig treeNodeConfig = new TreeNodeConfig();
        treeNodeConfig.setWeightKey("order");

        List<Tree<String>> menuTree = TreeUtil.build(menus, "0", treeNodeConfig, ((stringTreeNode, tree) -> {
            tree.setId(stringTreeNode.getId().toString());
            tree.setParentId(stringTreeNode.getParentId().toString());
            tree.setName(stringTreeNode.getName());
            tree.putExtra("path", stringTreeNode.getPath());
            tree.putExtra("component", stringTreeNode.getComponent());
            tree.putExtra("perms", stringTreeNode.getPerms());
            tree.putExtra("createTime", stringTreeNode.getCreateTime());
            tree.putExtra("createBy", stringTreeNode.getCreateBy());
            tree.putExtra("updateTime", stringTreeNode.getUpdateTime());
            tree.putExtra("updateBy", stringTreeNode.getUpdateBy());
        }));


        return ResultUtils.success(menuTree);
    }

}
