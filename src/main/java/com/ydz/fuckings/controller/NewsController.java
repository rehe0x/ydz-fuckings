package com.ydz.fuckings.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ydz.fuckings.business.mapper.NewsMapper;
import com.ydz.fuckings.business.model.News;
import com.ydz.fuckings.common.JsonResult;
import com.ydz.fuckings.common.MyException;
import com.ydz.fuckings.common.ResultCode;
import com.ydz.fuckings.controller.base.BaseController;

/**
 * 新闻接口
 * @author Administrator
 *
 */
@RestController
@EnableAutoConfiguration
@RequestMapping(value="/news")  
public class NewsController extends BaseController{
	
	/**News mapper*/
	@Autowired
	private NewsMapper newsMapper;
	
	
	/**
	 * 新增News
	 * @param info
	 * @return
	 */
    @RequestMapping(value="/insertNews", method=RequestMethod.POST)
	public JsonResult insertNews(News info)throws MyException{
		try {
			if(info.getId()==null||info.getId()==0){
				newsMapper.save(info);
			}else{
				newsMapper.update(info);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new MyException(ResultCode.ERROR.msg());
		}
		return new JsonResult();
	}
	
	
	/**
	 * 查询News 列表
	 * @return
	 */
    @RequestMapping(value="/findNews", method=RequestMethod.POST)
    public JsonResult findAll(Integer pageNum,Integer pageSize)throws MyException{
    	Page page= PageHelper.startPage(pageNum, pageSize);
		try {
			newsMapper.findAll();
		} catch (Exception e) {
			throw new MyException(ResultCode.ERROR.msg()); 
		}
		return new JsonResult(new PageInfo(page)); 
	}
    
    /**
	 * 查看News
	 * @return
	 */
    @RequestMapping(value="/findOne", method=RequestMethod.POST)
    public JsonResult findOne(Integer id)throws MyException{
    	Map map = null;
		try {
			map = newsMapper.findOne(id);
		} catch (Exception e) {
			throw new MyException(ResultCode.ERROR.msg());
		}
		return new JsonResult(map); 
	}
	
    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping(value="/delete", method=RequestMethod.POST)
    public JsonResult delete(Integer id)throws MyException{
		try {
			newsMapper.delete(id);
		} catch (Exception e) {
			throw new MyException(ResultCode.ERROR.msg());
		}
		return new JsonResult(); 
	}
	
	
}
