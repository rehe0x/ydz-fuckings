package com.ydz.fuckings.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;
import com.ydz.fuckings.controller.base.BaseController;

import springfox.documentation.annotations.ApiIgnore;
/**
 * API文档接口
* @ClassName: HomeAction 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author xieh 
* @date 2017年5月19日 上午10:06:32 
*
 */
@Controller
public class HomeAction extends BaseController {
	@ApiIgnore
	@RequestMapping(value = "/api")
    public String api() {
        return "redirect:/webapp/swagger/index.html";
    }
	
	@RequestMapping(value = "/api/testJsop")
	public void testJsop(String jsonpCallback1){
		this.getResponse().setContentType("text/plain");
		Map map= new HashMap();
		PrintWriter out = null;
		try {
			out = this.getResponse().getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         String jsonString = JSONObject.toJSONString(map);//随便使用哪个JSONObject都可以，这里只是转为json格式的字符串就行
         String jsonpCallback = this.getRequest().getParameter("jsonpCallback");// 客户端请求参数

         out.println(jsonpCallback + "(" + jsonString + ")");// 返回jsonp格式数据
	}
	
	
//	/**
//	 * 功能描述: jsonp测试，仅作示例： $.getJSON('/jsonp/test?callback=?', function(data){ alert(data.aaa) })
//	 */
//	@RequestMapping(value = "/test", method = RequestMethod.GET)
//	public @ResponseBody JSONPObject test(HttpServletResponse response, String callback) {
//	    Map<String, String> map = new HashMap<String, String>();
//	    map.put("aaa", "I'm Dreamlu！");
//	    return new JSONPObject(callback, map); //hellojsonp({"aaa":"I'm Dreamlu！"})
//	}

}
