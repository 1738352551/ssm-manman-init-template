package cn.chenmanman.ssm.controller;

import cn.chenmanman.ssm.common.BaseResponse;
import cn.chenmanman.ssm.common.DeleteRequest;
import cn.chenmanman.ssm.common.PageRequest;
import cn.chenmanman.ssm.common.ResultUtils;
import cn.chenmanman.ssm.model.dto.menu.MenuAddRequest;
import cn.chenmanman.ssm.model.dto.menu.MenuQueryRequest;
import cn.chenmanman.ssm.model.dto.menu.MenuUpdateRequest;
import cn.chenmanman.ssm.model.entity.Menu;
import cn.chenmanman.ssm.service.MenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@Api(value = "菜单管理", tags = {"菜单管理"})
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @ApiOperation(value = "分页查询菜单")
    @GetMapping
    public BaseResponse findMenuById(Long id) {
        return ResultUtils.success(menuService.queryMenuById(id));
    }

    @ApiOperation(value = "查询全部菜单")
    @PostMapping
    public BaseResponse findMenuByList(@Valid PageRequest pageRequest, @RequestBody MenuQueryRequest menuQueryRequest) {
        Menu menu = new Menu();
        BeanUtils.copyProperties(menuQueryRequest, menu);
        return ResultUtils.success(menuService.queryMenuList(pageRequest.getPageNum(), pageRequest.getPageSize(), menu));
    }


    @ApiOperation(value = "添加新的菜单")
    @PostMapping("/save")
    public BaseResponse saveMenu(@RequestBody @Valid MenuAddRequest menuAddRequest) {
        Menu menu = new Menu();
        BeanUtils.copyProperties(menuAddRequest, menu);
        return ResultUtils.toResponse(menuService.saveMenu(menu));
    }


    @ApiOperation(value = "修改菜单")
    @PutMapping
    public BaseResponse changeMenu(@RequestBody @Valid MenuUpdateRequest menuUpdateRequest) {
        Menu menu = new Menu();
        BeanUtils.copyProperties(menuUpdateRequest, menu);
        return ResultUtils.toResponse(menuService.changeMenu(menu));
    }


    @ApiOperation(value = "批量删除菜单")
    @DeleteMapping
    public BaseResponse removeByIds(@RequestBody DeleteRequest deleteRequest) {
        return ResultUtils.toResponse(menuService.removeMenuByIds(deleteRequest.getId()));
    }

}
