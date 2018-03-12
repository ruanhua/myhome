package cn.com.ulic.op.dao;


import cn.com.ulic.op.domain.MenuItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by ruanhua on 2017/6/5.
 */
@Mapper
public interface MenuMapper {
    //PC前端菜单
    @Select("SELECT id menuID, name, fbType, concat(URLPrefix,URL) url, status FROM cs_op_menu where clientType = 2 and fbType = 0 and parentMenu is null")
    List<MenuItem> getFrontendRootMenuItems();

    @Select("SELECT id menuID, name, fbType, URL url, status FROM cs_op_menu where clientType = 2 and fbType = 0 and parentMenu is not null")
    public List<MenuItem> getFrontendSubmenuItems();

    @Select("SELECT id menuID, name, fbType, URL url, status FROM cs_op_menu where clientType = 2 and fbType = 0 and parentMenu = #{parentMenu}")
    public List<MenuItem> getFrontendSubmenuItemsByParentMenuID(@Param("parentMenu") Integer parentMenu);

    @Select("SELECT id menuID, name, fbType, URL url, status FROM cs_op_menu where clientType = 0 and fbType = 0 and parentMenu is not null")
    public List<MenuItem> getMobileFrontendSubmenuItems();

    @Select("SELECT id menuID, name, fbType, URL url, status FROM cs_op_menu where clientType = 0 and fbType = 0 and parentMenu = #{parentMenu}")
    public List<MenuItem> getMobileFrontendSubmenuItemsByParentMenuID(@Param("parentMenu") Integer parentMenu);
}
