/**
 * 
 */
package cn.com.ulic.op.service;

import cn.com.ulic.op.domain.Menu;

import java.util.List;

/**
 * @author zhangzh75
 *
 */
public interface MenuService {
	/**
	 * 取得PC前端菜单
	 * @return
	 */
	public List<Menu> getFrontendMenus();
}
