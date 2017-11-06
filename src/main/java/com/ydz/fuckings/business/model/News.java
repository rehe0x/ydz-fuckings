package com.ydz.fuckings.business.model;

import java.io.Serializable;
import java.sql.Date;


/**
* 
* @author Lance
* @since 2017-05-13 14:38:56
*/
public class News implements Serializable {
	private static final long serialVersionUID = 1075959653L;

	/**主键*/
	private Integer id;

	/**新闻标题*/
	private String newsTitle;

	/**新闻内容*/
	private String newsContent;

	/**创建时间*/
	private Date createDate;

	/**状态 E可用 D不可用*/
	private String state;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNewsTitle() {
		return newsTitle;
	}

	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}

	public String getNewsContent() {
		return newsContent;
	}

	public void setNewsContent(String newsContent) {
		this.newsContent = newsContent;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}