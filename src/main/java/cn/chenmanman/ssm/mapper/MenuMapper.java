package cn.chenmanman.ssm.mapper;

import cn.chenmanman.ssm.model.entity.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuMapper {

    List<Menu> selectMenuAll();

    List<Menu> selectMenuList(Menu menu);

    Menu selectMenuById(Long id);

    boolean insertMenu(Menu menu);

    boolean updateMenu(Menu menu);

    boolean deleteMenuByIds(List<Long> ids);


    List<Menu> selectMenuByUserId(Long userId);
    List<Menu> selectMenuByUsername(String username);
    List<Menu> selectMenuByRoleId(Long id);



}
