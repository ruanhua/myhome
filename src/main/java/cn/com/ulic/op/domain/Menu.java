/**
 * 
 */
package cn.com.ulic.op.domain;

import java.util.List;

/**
 * @author zhangzh75
 *
 */
public class Menu {
	private List<MenuItem> menuItems;
	private Integer menuID;
	private Short clientType;
	private String name;
	private String url;
	/**
	 * 
	 */
	public Menu() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param menuID
	 * @param name
	 */
	public Menu(Integer menuID, String name) {
		super();
		this.menuID = menuID;
		this.name = name;
	}
	
	/**
	 * @param menuID
	 * @param name
	 * @param url
	 */
	public Menu(Integer menuID, String name, String url) {
		super();
		this.menuID = menuID;
		this.name = name;
		this.url = url;
	}

	public Menu(Integer menuID, Short clientType, String name, String url) {
		this.menuID = menuID;
		this.clientType = clientType;
		this.name = name;
		this.url = url;
	}

	/**
	 * @return the menuItems
	 */
	public List<MenuItem> getMenuItems() {
		return menuItems;
	}
	/**
	 * @param menuItems the menuItems to set
	 */
	public void setMenuItems(List<MenuItem> menuItems) {
		this.menuItems = menuItems;
	}
	/**
	 * @return the menuID
	 */
	public Integer getMenuID() {
		return menuID;
	}
	/**
	 * @param menuID the menuID to set
	 */
	public void setMenuID(Integer menuID) {
		this.menuID = menuID;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	public Short getClientType() {
		return clientType;
	}

	public void setClientType(Short clientType) {
		this.clientType = clientType;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
}
