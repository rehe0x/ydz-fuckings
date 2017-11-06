package com.ydz.fuckings.config;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ydz.fuckings.common.JsonResult;
import com.ydz.fuckings.common.MyException;
import com.ydz.fuckings.common.ResultCode;

/**
 * 异常拦截器
 * @author Administrator
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value=MyException.class)
	@ResponseBody
	public JsonResult jsonErrorHandler(HttpServletRequest req, MyException e){
		return new JsonResult(ResultCode.ERROR.code(), e.getMessage(), req.getRequestURL().toString());
	}
	
	@ExceptionHandler(value=Exception.class)
	@ResponseBody
	public JsonResult jsonErrorHandlers(HttpServletRequest req, Exception e){
		e.printStackTrace();
		return new JsonResult(ResultCode.ERROR.code(), e.getMessage(), req.getRequestURL().toString());
	}
}
