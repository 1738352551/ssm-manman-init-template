package cn.chenmanman.ssm.service;

import cn.chenmanman.ssm.model.entity.Menu;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface MenuService {

    List<Menu> queryMenuAll();

    PageInfo<Menu> queryMenuList(Integer pageNum, Integer pageSize, Menu menu);

    Menu queryMenuById(Long id);

    boolean saveMenu(Menu menu);

    boolean changeMenu(Menu menu);

    boolean removeMenuByIds(List<Long> ids);

    List<Menu> queryMenuByUserId(Long userId);
    List<Menu> queryMenuByUsername(String username);
    List<Menu> queryMenuByRoleId(Long id);

}
