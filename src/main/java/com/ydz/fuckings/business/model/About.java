package com.ydz.fuckings.business.model;

import java.io.Serializable;


/**
* 企业关于model
* @author xieh
* @since 2017-05-13 14:38:56
*/
public class About implements Serializable {
	private static final long serialVersionUID = 431435158L;

	/**主键*/
	private Integer id;

	/**关于标题*/
	private String aboutTitle;

	/**关于内容*/
	private String aboutContent;

	/**文化标题*/
	private String cultureTitle;

	/**文化内容*/
	private String cultureContent;

	/**产品标题*/
	private String productTitle;

	/**产品描述*/
	private String productContent;

	/**网站标题*/
	private String siteTitle;

	/**宣传语*/
	private String slogan;

	/**联系电话*/
	private String siteTel;

	/**联系邮箱*/
	private String siteEmail;
	/**版权说明*/
	private String copyrightTitle;
	/**联系微信图片*/
	private String siteWeimg;
	/**客户代码*/
	private String serviceCode;
	
	public String getSiteWeimg() {
		return siteWeimg;
	}

	public void setSiteWeimg(String siteWeimg) {
		this.siteWeimg = siteWeimg;
	}

	public String getServiceCode() {
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}

	public String getCopyrightTitle() {
		return copyrightTitle;
	}

	public void setCopyrightTitle(String copyrightTitle) {
		this.copyrightTitle = copyrightTitle;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAboutTitle() {
		return aboutTitle;
	}

	public void setAboutTitle(String aboutTitle) {
		this.aboutTitle = aboutTitle;
	}

	public String getAboutContent() {
		return aboutContent;
	}

	public void setAboutContent(String aboutContent) {
		this.aboutContent = aboutContent;
	}

	public String getCultureTitle() {
		return cultureTitle;
	}

	public void setCultureTitle(String cultureTitle) {
		this.cultureTitle = cultureTitle;
	}

	public String getCultureContent() {
		return cultureContent;
	}

	public void setCultureContent(String cultureContent) {
		this.cultureContent = cultureContent;
	}

	public String getProductTitle() {
		return productTitle;
	}

	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}

	public String getProductContent() {
		return productContent;
	}

	public void setProductContent(String productContent) {
		this.productContent = productContent;
	}

	public String getSiteTitle() {
		return siteTitle;
	}

	public void setSiteTitle(String siteTitle) {
		this.siteTitle = siteTitle;
	}

	public String getSlogan() {
		return slogan;
	}

	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}

	public String getSiteTel() {
		return siteTel;
	}

	public void setSiteTel(String siteTel) {
		this.siteTel = siteTel;
	}

	public String getSiteEmail() {
		return siteEmail;
	}

	public void setSiteEmail(String siteEmail) {
		this.siteEmail = siteEmail;
	}

	@Override
	public String toString() {
		return "About [id=" + id + ", aboutTitle=" + aboutTitle + ", aboutContent=" + aboutContent + ", cultureTitle="
				+ cultureTitle + ", cultureContent=" + cultureContent + ", productTitle=" + productTitle
				+ ", productContent=" + productContent + ", siteTitle=" + siteTitle + ", slogan=" + slogan
				+ ", siteTel=" + siteTel + ", siteEmail=" + siteEmail + "]";
	}

	
	
}