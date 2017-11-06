package com.ydz.fuckings.business.model;

import java.io.Serializable;
import java.util.Date;


/**
* 
* @author Lance
* @since 2017-05-13 14:38:56
*/
public class LotteryOrder implements Serializable {
	private static final long serialVersionUID = 223006513L;

	/**主键*/
	private Integer id;

	/**订单号*/
	private String orderNbr;

	/**彩票ID*/
	private Integer caipiaoid;

	/**下注号*/
	private String lotteryNbr;

	/**下注注数*/
	private Integer lotteryNum;

	/**用户ID*/
	private Integer userId;

	/**身份证*/
	private String carded;

	/**手机号*/
	private String phone;

	/**订单金额*/
	private double orderMoney;

	/**创建时间*/
	private Date createDate;

	/**E可用 D不可用*/
	private String state;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrderNbr() {
		return orderNbr;
	}

	public void setOrderNbr(String orderNbr) {
		this.orderNbr = orderNbr;
	}

	public Integer getCaipiaoid() {
		return caipiaoid;
	}

	public void setCaipiaoid(Integer caipiaoid) {
		this.caipiaoid = caipiaoid;
	}

	public String getLotteryNbr() {
		return lotteryNbr;
	}

	public void setLotteryNbr(String lotteryNbr) {
		this.lotteryNbr = lotteryNbr;
	}

	public Integer getLotteryNum() {
		return lotteryNum;
	}

	public void setLotteryNum(Integer lotteryNum) {
		this.lotteryNum = lotteryNum;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getCarded() {
		return carded;
	}

	public void setCarded(String carded) {
		this.carded = carded;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public double getOrderMoney() {
		return orderMoney;
	}

	public void setOrderMoney(double orderMoney) {
		this.orderMoney = orderMoney;
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