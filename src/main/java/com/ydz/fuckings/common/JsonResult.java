package com.ydz.fuckings.common;
/**
 * 返回JSON对象
 * @author Administrator
 *
 */
public class JsonResult {
	
	private String code;
	
	private String message;
	
	private Object data;
	
	public JsonResult() {
		this.setCode(ResultCode.SUCCESS);
		this.setMessage(ResultCode.SUCCESS.msg());
	}
	
	
	public JsonResult(ResultCode code) {
		this.setCode(code);
		this.setMessage(code.msg());
	}


	public JsonResult(Object data) {
		this.data = data;
		this.setCode(ResultCode.SUCCESS);
		this.setMessage(ResultCode.SUCCESS.msg());
	}



	public JsonResult(ResultCode code, Object data) {
		this.setCode(code);
		this.setMessage(code.msg());
		this.setData(data);
	}



	public JsonResult(String code, String message, Object data) {
		this.code = code;
		this.message = message;
		this.data = data;
	}


	public String getCode() {
		return code;
	}
	public void setCode(ResultCode code) {
		this.code = code.code();
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	
	
}
