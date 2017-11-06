package com.ydz.fuckings.business.model;
/**
 * 产品分类
* @ClassName: ClassDom 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author xieh 
* @date 2017年6月6日 下午3:36:33 
*
 */
public class ClassDom {
	/**主键*/
	private Integer id;
	/**上级ID*/
	private Integer superId;
	/**分类名称*/
	private String className;
	/**状态E可用 D不可用*/
	private String state;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getSuperId() {
		return superId;
	}
	public void setSuperId(Integer superId) {
		this.superId = superId;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	private ClassDom() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
