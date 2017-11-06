package com.ydz.fuckings.controller.base;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;

public class BaseAction {
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	
	@ModelAttribute
	public void init(HttpServletRequest request,HttpServletResponse response){
		this.request=request;
		this.response=response;
	}
}
