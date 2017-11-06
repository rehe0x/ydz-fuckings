package com.ydz.fuckings.business.model;

import java.io.Serializable;
import java.util.Date;


/**
* 
* @author Lance
* @since 2017-05-13 14:38:56
*/
public class Join implements Serializable {
	private static final long serialVersionUID = 94414711L;

	/**主键*/
	private Integer id;

	/**姓名*/
	private String name;

	/**邮箱*/
	private String email;

	/**电话*/
	private String phone;

	/**留言*/
	private String message;

	/***/
	private String state;
	
	/**时间*/
	private Date createDate;
	
	
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}