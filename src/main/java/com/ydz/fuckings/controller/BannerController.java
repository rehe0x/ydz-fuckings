package com.ydz.fuckings.controller;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ydz.fuckings.business.mapper.BannerMapper;
import com.ydz.fuckings.business.model.Banner;
import com.ydz.fuckings.common.JsonResult;
import com.ydz.fuckings.common.MyException;
import com.ydz.fuckings.common.ResultCode;
import com.ydz.fuckings.controller.base.BaseController;

import io.swagger.annotations.Api;

/**
 * BannerAction
 * @author Administrator
 *
 */
@Api(description = "Banner相关接口")
@RestController
@EnableAutoConfiguration
@RequestMapping(value="/banner")  
public class BannerController extends BaseController{
	
	/**Banner mapper*/
	@Autowired
	private BannerMapper bannerMapper;
	
	
	/**
	 * 新增banner
	 * @param info
	 * @return
	 */
    @RequestMapping(value="/insertBanner", method=RequestMethod.POST)
	public JsonResult insertBanner(Banner info)throws MyException{
		try {
			if(info.getId()==null||info.getId()==0){
				info.setCreateDate(new Date());
				bannerMapper.save(info);
			}else{
				bannerMapper.update(info);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new MyException(ResultCode.ERROR.msg());
		}
		return new JsonResult();
	}
	
	
	/**
	 * 查询banner 列表
	 * @return
	 */
    @RequestMapping(value="/findBanner", method=RequestMethod.POST)
    public JsonResult findBanner(Integer pageNum,Integer pageSize,String place){
    	Page page= PageHelper.startPage(pageNum, pageSize);
		try {
			bannerMapper.findBanner(place);
		} catch (Exception e) {
			new MyException(ResultCode.ERROR.msg()); 
		}
		return new JsonResult(new PageInfo(page)); 
	}
    
    /**
	 * 查看banner
	 * @return
	 */
    @RequestMapping(value="/findOne", method=RequestMethod.POST)
    public JsonResult findOne(Integer id){
    	Map map = null;
		try {
			map = bannerMapper.findOne(id);
		} catch (Exception e) {
			new MyException(ResultCode.ERROR.msg());
		}
		return new JsonResult(map); 
	}
	
    @RequestMapping(value="/delete", method=RequestMethod.POST)
    public JsonResult delete(Integer id){
		try {
			 bannerMapper.delete(id);
		} catch (Exception e) {
			new MyException(ResultCode.ERROR.msg());
		}
		return new JsonResult(); 
	}
	
	
}
