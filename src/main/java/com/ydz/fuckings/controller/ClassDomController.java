package com.ydz.fuckings.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ydz.fuckings.business.mapper.ClassDomMapper;
import com.ydz.fuckings.business.model.ClassDom;
import com.ydz.fuckings.common.JsonResult;
import com.ydz.fuckings.common.MyException;
import com.ydz.fuckings.common.ResultCode;
import com.ydz.fuckings.controller.base.BaseController;

/**
 * 分类
 * @author Administrator
 *
 */
@RestController
@EnableAutoConfiguration
@RequestMapping(value="/classdom")  
public class ClassDomController extends BaseController{
	
	/**News mapper*/
	@Autowired
	private ClassDomMapper classDomMapper;
	
	
	/**
	 * 新增classdom
	 * @param info
	 * @return
	 */
    @RequestMapping(value="/insertClassDom", method=RequestMethod.POST)
	public JsonResult insertNews(ClassDom info)throws MyException{
		try {
			if(info.getId()==null||info.getId()==0){
				classDomMapper.save(info);
			}else{
				classDomMapper.update(info);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new MyException(ResultCode.ERROR.msg());
		}
		return new JsonResult();
	}
	
	
	/**
	 * 查询classdom 列表
	 * @return
	 */
    @RequestMapping(value="/findClassDom", method=RequestMethod.POST)
    public JsonResult findClassDom()throws MyException{
    	List<Map> listMap = null;
		try {
			listMap = classDomMapper.findAll();
		} catch (Exception e) {
			throw new MyException(ResultCode.ERROR.msg()); 
		}
		return new JsonResult(listMap); 
	}
    
    /**
	 * 查看classdom
	 * @return
	 */
    @RequestMapping(value="/findOne", method=RequestMethod.POST)
    public JsonResult findOne(Integer id)throws MyException{
    	Map map = null;
		try {
			map = classDomMapper.findOne(id);
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
			classDomMapper.delete(id);
		} catch (Exception e) {
			throw new MyException(ResultCode.ERROR.msg());
		}
		return new JsonResult(); 
	}
	
	
}
