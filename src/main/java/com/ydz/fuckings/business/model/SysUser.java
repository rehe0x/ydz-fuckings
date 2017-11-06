package com.ydz.fuckings.business.model;

import java.io.Serializable;
import java.util.Date;


/**
* 
* @author xch
* @since 2017-05-12 23:24:49
*/
public class SysUser implements Serializable {
	private static final long serialVersionUID = 2114381149L;

	/**主键*/
	private Integer id;

	/**登录账号*/
	private String account;

	/**用户名*/
	private String name;

	/**用户手机号*/
	private String pwd;

	/**状态*/
	private String state;
	
	/**创建时间*/
	private Date createDate;

	
	
	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public SysUser() {
		super();
		// TODO Auto-generated constructor stub
	}


}