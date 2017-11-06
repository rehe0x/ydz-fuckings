package com.ydz.fuckings.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.ydz.fuckings.business.mapper.UserMapper;
import com.ydz.fuckings.business.model.User;
import com.ydz.fuckings.common.JsonResult;
import com.ydz.fuckings.common.ResultCode;
import com.ydz.fuckings.controller.base.BaseController;
import com.ydz.fuckings.thirdparty.JisuApi;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 用户action
 * @author Administrator
 *
 */
@Api(description = "用户相关接口")
@RestController
@EnableAutoConfiguration
@RequestMapping(value="/users")  
public class UserAction extends BaseController{
	
	/**用户mapper*/
	@Autowired
	private UserMapper userMapper;
	
	
	@ApiOperation(value="用户注册", notes="注册用户 ")
	@ApiImplicitParams({
		@ApiImplicitParam(name="userAccount",value="登录账号 不要传中文",required=true,dataType="String",paramType="query"),
		@ApiImplicitParam(name="userName",value="昵称 非必传 不要传中文",required=false,dataType="String",paramType="query"),
		@ApiImplicitParam(name="userPhone",value="手机号 非必传",required=false,dataType="String",paramType="query"),
		@ApiImplicitParam(name="pwd",value="密码",required=true,dataType="String",paramType="query"),
	})
    @RequestMapping(value="/signUp", method=RequestMethod.POST)
	public JsonResult signUp(String userAccount,String userName,String userPhone,String pwd){
		User user1 = userMapper.findByUser(userAccount, null);
		if(user1!=null&&user1.getId()!=0){
			return new JsonResult(ResultCode.REPETITION_ERROR);
		}
		User user = new User(userAccount, userName, userPhone, pwd);
		Integer i = userMapper.save(user);
		return new JsonResult(i);
	} 
	
	
	@ApiOperation(value="用户登陆",response=User.class, notes="用户登陆 ")
	@ApiImplicitParams({ 
		@ApiImplicitParam(name="userAccount",value="登录账号",required=true,dataType="String",paramType="query"),
		@ApiImplicitParam(name="pwd",value="密码",required=true,dataType="String",paramType="query"),
	})
    @RequestMapping(value="/login", method=RequestMethod.POST)
	public JsonResult login(String userAccount,String pwd){
		User user = userMapper.findByUser(userAccount, null);
		if(user!=null){
			User user1 = userMapper.findByUser(userAccount, pwd);
			if(user1!=null&&user1.getId()!=0){
				return new JsonResult(user1);
			}else{
				return new JsonResult(ResultCode.ACCOUNT_PWD_ERROR);
			}
		}else{
			return new JsonResult(ResultCode.ACCOUNT_IS_NULL);
		}
	}  
	
	@ApiOperation(value="机器人自动回复", notes="机器人自动回复 在线客户 ",response = JsonResult.class )
	@ApiImplicitParam(name="question",value="用户输入内容  如：你好！彩票怎么购买！",required=true,dataType="String",paramType="query")
    @RequestMapping(value="/iqaQuery", method=RequestMethod.POST)
	
	public JsonResult iqaQuery(String question){
		System.out.println(this.getRequest().getHeader("User-Agent"));
		JSONObject jsonObj = JisuApi.iqaQuery(question);
		  //根目录路径
        String rootPath = this.getRequest().getRealPath("/");
        //根目录URL
        String rootUrl  =  this.getRequest().getContextPath();
        System.out.println(this.getRequest().getSession().getServletContext().getRealPath("/"));
		return new JsonResult(jsonObj);
	}
	
	@RequestMapping(value="/SFSS", method=RequestMethod.GET)
	@ResponseBody
	public String swww(){
		return "error";
	}
	
}
