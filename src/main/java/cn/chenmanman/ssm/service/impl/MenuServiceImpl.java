package cn.chenmanman.ssm.service.impl;

import cn.chenmanman.ssm.exception.BusinessException;
import cn.chenmanman.ssm.mapper.MenuMapper;
import cn.chenmanman.ssm.mapper.RoleMapper;
import cn.chenmanman.ssm.mapper.UserMapper;
import cn.chenmanman.ssm.model.entity.Menu;
import cn.chenmanman.ssm.model.entity.Role;
import cn.chenmanman.ssm.model.entity.User;
import cn.chenmanman.ssm.service.MenuService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Menu> queryMenuAll() {
        return menuMapper.selectMenuAll();
    }

    @Override
    public PageInfo<Menu> queryMenuList(Integer pageNum, Integer pageSize, Menu menu) {
        PageHelper.startPage(pageNum, pageSize);

        return new PageInfo<>(menuMapper.selectMenuList(menu));
    }

    @Override
    public Menu queryMenuById(Long id) {
        return menuMapper.selectMenuById(id);
    }

    @Override
    public boolean saveMenu(Menu menu) {
        Menu menu1 = menuMapper.selectMenuById(menu.getId());
        if (menu1 != null) {
            throw new BusinessException(5000, "该菜单已经存在了!");
        }
        menuMapper.insertMenu(menu);
        return true;
    }

    @Override
    public boolean changeMenu(Menu menu) {
        Menu menu1 = menuMapper.selectMenuById(menu.getId());
        if (menu1 == null) {
            throw new BusinessException(5000, "该菜单不存在!");
        }
        menuMapper.updateMenu(menu);
        return true;
    }

    @Override
    public boolean removeMenuByIds(List<Long> ids) {
        boolean match = ids.stream().anyMatch(id -> menuMapper.selectMenuById(id) == null);
        if (match) {
            throw new BusinessException(5000, "不好意思, 这组菜单可能存在已被删除或不存在的!");
        }
        menuMapper.deleteMenuByIds(ids);
        return true;
    }

    @Override
    public List<Menu> queryMenuByUserId(Long userId) {
        User user = userMapper.selectUserById(userId);
        if (user==null){
            throw new BusinessException(5000, "用户不存在!无法找到其所能操作的菜单");
        }
        return menuMapper.selectMenuByUserId(userId);
    }

    @Override
    public List<Menu> queryMenuByUsername(String username) {
        User user = userMapper.selectUserByUsername(username);
        if (user==null){
            throw new BusinessException(5000, "用户不存在!无法找到其所能操作的菜单");
        }
        return menuMapper.selectMenuByUsername(username);
    }

    @Override
    public List<Menu> queryMenuByRoleId(Long id) {
        Role role = roleMapper.selectRoleById(id);
        if (role==null){
            throw new BusinessException(5000, "角色不存在!无法找到其所能操作的菜单");
        }
        return menuMapper.selectMenuByRoleId(id);
    }
}
