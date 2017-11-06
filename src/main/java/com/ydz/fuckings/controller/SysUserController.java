package com.ydz.fuckings.controller;

import java.util.Date;

import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ydz.fuckings.business.mapper.SysUserMapper;
import com.ydz.fuckings.business.model.SysUser;
import com.ydz.fuckings.common.JsonResult;
import com.ydz.fuckings.common.MyException;
import com.ydz.fuckings.common.ResultCode;
import com.ydz.fuckings.controller.base.BaseController;

/**
 * 系统用户
 * @author Administrator
 *
 */
@RestController
@EnableAutoConfiguration
@RequestMapping(value="/sysuser")  
public class SysUserController extends BaseController{
	
	/**Sys mapper*/
	@Autowired
	private SysUserMapper sysUserMapper;
	
	
	/**
	 * 新增sysUser
	 * @param info
	 * @return
	 */
    @RequestMapping(value="/insertSysUser", method=RequestMethod.POST)
	public JsonResult insertSysUser(SysUser info)throws MyException{
		try {
			if(info.getId()==null||info.getId()==0){
				info.setCreateDate(new Date());
				sysUserMapper.save(info);
			}else{
				sysUserMapper.update(info);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new MyException(ResultCode.ERROR.msg());
		}
		return new JsonResult();
	}
	
	
	/**
	 * 查询系统用户 列表
	 * @return
	 */
    @RequestMapping(value="/findSysUser", method=RequestMethod.POST)
    public JsonResult findAll(Integer pageNum,Integer pageSize,SysUser info)throws MyException{
    	Page page= PageHelper.startPage(pageNum, pageSize);
		try {
			sysUserMapper.findAll(info);
		} catch (Exception e) {
			throw new MyException(ResultCode.ERROR.msg()); 
		}
		return new JsonResult(new PageInfo(page)); 
	}
    
    /**
	 * 查看Sys
	 * @return
	 */
    @RequestMapping(value="/findOne", method=RequestMethod.POST)
    public JsonResult findOne(Integer id)throws MyException{
    	SysUser info = null;
		try {
			info = sysUserMapper.findOne(id);
		} catch (Exception e) {
			throw new MyException(ResultCode.ERROR.msg());
		}
		return new JsonResult(info); 
	}
	
    /**
     * 删除SYS
     * @param id
     * @return
     */
    @RequestMapping(value="/delete", method=RequestMethod.POST)
    public JsonResult delete(Integer id)throws MyException{
		try {
			sysUserMapper.delete(id);
		} catch (Exception e) {
			throw new MyException(ResultCode.ERROR.msg());
		}
		return new JsonResult(); 
	}
	
    
    /**
     * 登录
     * @param userAccount
     * @param pwd
     * @return
     */
    @RequestMapping(value="/sysLogin", method=RequestMethod.POST)
	public JsonResult sysLogin(String account,String pwd){
		SysUser user = sysUserMapper.findBySysUserAccount(account);
		if(user!=null){
			SysUser user1 = sysUserMapper.findBySysUserAccountPwd(account, pwd);
			if(user1!=null&&user1.getId()!=0){
				this.getRequest().getSession().setAttribute("name", user1.getName());
				this.getRequest().getSession().setAttribute("account", user1.getAccount());
				this.getRequest().getSession().setAttribute("userId", user1.getId());
				return new JsonResult(user1);
			}else{
				return new JsonResult(ResultCode.ACCOUNT_PWD_ERROR);
			}
		}else{
			return new JsonResult(ResultCode.ACCOUNT_IS_NULL);
		}
	}
    
    /**
	 * 获取当前用户
	 * @return
	 */
    @RequestMapping(value="/getSessionUser", method=RequestMethod.POST)
    public JsonResult getSessionUser()throws MyException{
    	SysUser info = null;
		try {
			info = sysUserMapper.findOne(Integer.parseInt(this.getRequest().getSession().getAttribute("userId").toString()));
		} catch (Exception e) {
			throw new MyException(ResultCode.ERROR.msg());
		}
		return new JsonResult(info); 
	}
    
    /**
     * 退出登录
     * @return
     */
    @RequestMapping(value="/outLogin", method=RequestMethod.POST)
	public JsonResult outLogin(){
		this.getRequest().getSession().invalidate();
		return new JsonResult();
	}  
	
}
