package cn.chenmanman.ssm.controller;

import cn.chenmanman.ssm.common.*;
import cn.chenmanman.ssm.exception.BusinessException;
import cn.chenmanman.ssm.model.dto.user.UserAddRequest;
import cn.chenmanman.ssm.model.dto.user.UserLoginRequest;
import cn.chenmanman.ssm.model.dto.user.UserQueryRequest;
import cn.chenmanman.ssm.model.dto.user.UserUpdateRequest;
import cn.chenmanman.ssm.model.entity.Menu;
import cn.chenmanman.ssm.model.entity.Role;
import cn.chenmanman.ssm.model.entity.User;
import cn.chenmanman.ssm.service.MenuService;
import cn.chenmanman.ssm.service.RoleService;
import cn.chenmanman.ssm.service.UserService;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeNode;
import cn.hutool.core.lang.tree.TreeNodeConfig;
import cn.hutool.core.lang.tree.TreeUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Api(value = "用户管理", tags = {"用户管理"})
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private MenuService menuService;

    @ApiOperation(value = "分页查询用户")
    @PostMapping
    public BaseResponse<?> findUserPage(PageRequest pageRequest, @RequestBody UserQueryRequest userQueryRequest) {
        User user = new User();
        BeanUtils.copyProperties(userQueryRequest, user);
        return ResultUtils.success(userService.queryUserPage(pageRequest.getPageNum(), pageRequest.getPageSize(), user));
    }


    /**
     * 用户添加接口
     *
     * */
    @ApiOperation(value = "添加用户")
    @PostMapping("/save")
    public BaseResponse<?> addUser(@RequestBody UserAddRequest userAddRequest) {
        if (Objects.isNull(userAddRequest)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        User user = new User();
        BeanUtils.copyProperties(userAddRequest, user);
        return ResultUtils.toResponse(userService.addUser(user));
    }


    @ApiOperation(value = "修改用户信息")
    @PutMapping
    public BaseResponse<?> changeUser(@RequestBody UserUpdateRequest userUpdateRequest) {
        if (Objects.isNull(userUpdateRequest)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        User user = new User();
        BeanUtils.copyProperties(userUpdateRequest, user);
        return ResultUtils.toResponse(userService.updateUser(user));
    }

    @ApiOperation(value = "批量删除用户")
    @DeleteMapping
    public BaseResponse<?> removeUser(@RequestBody DeleteRequest deleteRequest) {
        if (Objects.isNull(deleteRequest)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        return ResultUtils.toResponse(userService.removeUserByIds(deleteRequest.getId()));
    }

    @ApiOperation(value = "根据id获取指定用户信息")
    @GetMapping("/{id}")
    public BaseResponse<?> getUserById(@PathVariable("id") Long id) {
        if (Objects.isNull(id)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }

        return ResultUtils.success(userService.queryUserById(id));
    }


    /**
     * 查角色所拥有的角色也就是身份
     * */
    @ApiOperation("查角色所拥有的角色")
    @GetMapping("/authRole/{userId}")
    public BaseResponse authRole(@PathVariable("userId") Long userId)
    {
        HashMap<String, Object> map = new HashMap<>();
        User user = userService.queryUserById(userId);
        List<Role> roles = roleService.selectRolesByUserId(userId);
        map.put("user", user);
        map.put("roles", User.isAdmin(userId) ? roles : roles.stream().filter(r -> !r.isAdmin()).collect(Collectors.toList()));
        return ResultUtils.success(map);
    }

    /**
     * 批量给用户分配角色
     * */
    @ApiOperation("批量给用户分配角色")
    @PutMapping("/authRole")
    public BaseResponse insertAuthRole(Long userId, @RequestBody Long[] roleIds)
    {
        userService.insertUserAuth(userId, roleIds);
        return ResultUtils.success(null);
    }

    @PostMapping("/login")
    public BaseResponse login(@RequestBody UserLoginRequest userLoginRequest) {
        return ResultUtils.success(userService.login(userLoginRequest.getUsername(), userLoginRequest.getPassword(), userLoginRequest.getCode(), userLoginRequest.getUuid()));
    }


    @ApiOperation("查用户可以操作的菜单")
    @GetMapping("/menu/{userId}")
    public BaseResponse getMenuByUserid(@PathVariable("userId") Long userId){
        if (userId==null){
            throw new BusinessException(5000, "请填写用户id");
        }

        List<Menu> menus = menuService.queryMenuByUserId(userId);
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

    @ApiOperation("查用户可以操作的菜单username")
    @GetMapping("/menu/{username}")
    public BaseResponse getMenuByUsername(@PathVariable("username") String username){
        if (username==null){
            throw new BusinessException(5000, "请填写用户名");
        }

        List<Menu> menus = menuService.queryMenuByUsername(username);
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
