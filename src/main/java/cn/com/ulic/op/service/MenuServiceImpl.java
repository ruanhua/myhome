/**
 * 
 */
package cn.com.ulic.op.service;

import cn.com.ulic.op.dao.MenuMapper;
import cn.com.ulic.op.domain.Menu;
import cn.com.ulic.op.domain.MenuItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangzh75
 *
 */
@Service
public class MenuServiceImpl implements MenuService {
	@Autowired
	private MenuMapper menuMapper;

	@Override
	public List<Menu> getFrontendMenus() {
		List<Menu> frontendMenus = null;
		List<MenuItem> frontendRootMenuItems = menuMapper.getFrontendRootMenuItems();
		if(frontendRootMenuItems != null && frontendRootMenuItems.size() > 0){
			frontendMenus = new ArrayList<Menu>();
			for(MenuItem menuItem : frontendRootMenuItems) {
                Integer menuID = menuItem.getMenuID();
                Menu menu = new Menu(menuID, menuItem.getName(), menuItem.getUrl());
                List<MenuItem> menuItems = menuMapper.getFrontendSubmenuItemsByParentMenuID(menuID);
                menu.setMenuItems(menuItems);
                frontendMenus.add(menu);
            }
		}
		return frontendMenus;
	}
}
