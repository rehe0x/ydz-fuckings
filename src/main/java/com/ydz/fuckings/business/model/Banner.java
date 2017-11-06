package com.ydz.fuckings.business.model;

import java.io.Serializable;
import java.util.Date;


/**
* 
* @author Lance
* @since 2017-05-13 14:38:56
*/
public class Banner implements Serializable {
	private static final long serialVersionUID = 692555450L;

	/**主键*/
	private Integer id;

	/**标题*/
	private String title;

	/**图片*/
	private String img;

	/**跳转链接*/
	private String url;

	/**具体位置 1首页  2个人中心  3其他*/
	private String place;

	/**跳转类型*/
	private String type;

	/**状态E可用 D不可用*/
	private String state;
	/**创建时间*/
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}