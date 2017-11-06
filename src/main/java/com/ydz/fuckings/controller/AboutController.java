package com.ydz.fuckings.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ydz.fuckings.business.mapper.AboutMapper;
import com.ydz.fuckings.business.model.About;
import com.ydz.fuckings.business.service.IAboutService;
import com.ydz.fuckings.common.JsonResult;
import com.ydz.fuckings.common.MyException;
import com.ydz.fuckings.common.ResultCode;
import com.ydz.fuckings.controller.base.BaseController;

import springfox.documentation.annotations.ApiIgnore;

/**
 * 关于企业
 * @author Administrator
 *
 */
@ApiIgnore
@RestController
@RequestMapping(value="/about")  
public class AboutController extends BaseController{
	
	/**关于mapper*/
	@Autowired
	private AboutMapper aboutMapper;
	/**关于service*/
	@Autowired
	private IAboutService iAboutService;
	
	/**
	 * 保存关于配置
	 * @param info
	 * @return
	 */
	@RequestMapping(value="/insertAbout", method=RequestMethod.POST)
	public JsonResult insertAbout(About info){
		try {
			iAboutService.saveAbout(info);
		} catch (Exception e) {
			e.printStackTrace();
			new MyException(ResultCode.ERROR.msg());
		}
		return new JsonResult();
	}
	
	/**
	 * 查询企业配置信息
	 * @return
	 */
	@RequestMapping(value="/getAbout")
	public JsonResult getAbout(){
		Map map = null;
		try {
			map = aboutMapper.findOne(null);
		} catch (MyException e) {
			e.printStackTrace();
			new MyException(ResultCode.ERROR.msg());
		}
		return new JsonResult(map); 
	}
}
