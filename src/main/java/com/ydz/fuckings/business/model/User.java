package com.ydz.fuckings.business.model;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;


/**
* 
* @author xch
* @since 2017-05-12 23:24:49
*/
public class User implements Serializable {
	private static final long serialVersionUID = 2114381149L;

	/**主键*/
	private Integer id;

	/**登录账号*/
	@ApiModelProperty(value = "登陆账号")
	private String userAccount;

	/**用户名*/
	private String userName;

	/**用户手机号*/
	private String userPhone;

	/**用户密码*/
	private String pwd;

	/**邮箱*/
	private String email;

	/**头像*/
	private String img;

	/**状态*/
	private String state;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String userAccount, String userName, String userPhone, String pwd) {
		this.userAccount = userAccount;
		this.userName = userName;
		this.userPhone = userPhone;
		this.pwd = pwd;
	}
	
	
	

}