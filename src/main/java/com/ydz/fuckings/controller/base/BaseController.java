package com.ydz.fuckings.controller.base;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;

import springfox.documentation.annotations.ApiIgnore;

@ControllerAdvice
@ApiIgnore
public class BaseController {
	
	@Resource
	private HttpServletRequest request;
	@Resource
	private HttpServletResponse response;
	
	public final HttpServletRequest getRequest() {
		return request;
	}

	public final HttpServletResponse getResponse() {
		return response;
	}
	
	
}
