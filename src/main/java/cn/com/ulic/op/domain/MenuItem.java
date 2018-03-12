/**
 * 
 */
package cn.com.ulic.op.domain;

/**
 * @author zhangzh75
 *
 */
public class MenuItem {
	private Integer menuID;
	private String name;
	private Short fbType;
	private String url;
	private Short status;

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
	/**
	 * @return the fbType
	 */
	public Short getFbType() {
		return fbType;
	}

	/**
	 * @param fbType the fbType to set
	 */
	public void setFbType(Short fbType) {
		this.fbType = fbType;
	}

	/**
	 * @return the status
	 */
	public Short getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Short status) {
		this.status = status;
	}
}
