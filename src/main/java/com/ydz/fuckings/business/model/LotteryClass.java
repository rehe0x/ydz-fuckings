package com.ydz.fuckings.business.model;

import java.io.Serializable;


/**
* 
* @author Lance
* @since 2017-05-13 12:32:37
*/
public class LotteryClass implements Serializable {
	private static final long serialVersionUID = 1877381796L;

	/**主键*/
	private Integer id;

	/**彩票ID 极速API*/
	private Integer caipiaoid;

	/**彩票名称*/
	private String name;

	/**彩票区域*/
	private String parentid;

	/**状态E可用 D不可用*/
	private String state;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCaipiaoid() {
		return caipiaoid;
	}

	public void setCaipiaoid(Integer caipiaoid) {
		this.caipiaoid = caipiaoid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParentid() {
		return parentid;
	}

	public void setParentid(String parentid) {
		this.parentid = parentid;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}