package com.ydz.fuckings.common;

/**
 * 错误码
 * @author Administrator
 *
 */
public enum ResultCode {
	
	/** 成功 */
	ERROR("100", "失败"),
	
	/** 成功 */
	SUCCESS("200", "成功"),
	
	/** 没有登录 */
	NOT_LOGIN("400", "没有登录"),
	
	/** 发生异常 */
	EXCEPTION("401", "发生异常"),
	
	/** 系统错误 */
	SYS_ERROR("402", "系统错误"),
	
	/** 参数错误 */
	PARAMS_ERROR("403", "参数错误 "),
	
	/** 不支持或已经废弃 */
	NOT_SUPPORTED("410", "不支持或已经废弃"),
	
	/** AuthCode错误 */
	INVALID_AUTHCODE("444", "无效的AuthCode"),

	/** 太频繁的调用 */
	TOO_FREQUENT("445", "太频繁的调用"),
	
	/** 未知的错误 */
	UNKNOWN_ERROR("499", "未知错误"),
	
	
	/**该账号已被注册*/
	REPETITION_ERROR("500","该账号已被注册"),
	
	/**账号或密码错误！*/
	ACCOUNT_PWD_ERROR("501","账号或密码错误"),
	
	/**该账号未注册*/
	ACCOUNT_IS_NULL("502","该账号未注册！");
	
	
	private ResultCode(String code, String msg){
		this.code = code;
		this.msg = msg;
	}
	
	public String code() {
		return code;
	}

	public String msg() {
		return msg;
	}
	
	private String code;
	private String msg;
}
