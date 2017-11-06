package com.ydz.fuckings.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class ActionInterceptor implements HandlerInterceptor{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		String accept=request.getHeader("accept");
		if(null==request.getSession().getAttribute("userId")){
			if(accept!=null&&(accept.startsWith("text/html")||accept.startsWith("image/webp"))){
				response.sendRedirect("/admin/login.html");
				return false;
			}else{
				JSONObject json = (JSONObject) JSON.toJSON(new JsonResult(ResultCode.NOT_LOGIN,"/admin/login.html"));
				response.setContentType("application/json;charset=UTF-8");
				response.getWriter().write(json.toString());
				response.getWriter().flush();
				response.getWriter().close();
				return false;
	        }
		}else{
			return true;
		}
	}
	
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	

}
