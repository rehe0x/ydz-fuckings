package com.ydz.fuckings.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ydz.fuckings.business.mapper.JoinMapper;
import com.ydz.fuckings.business.model.Join;
import com.ydz.fuckings.common.JsonResult;
import com.ydz.fuckings.common.MyException;
import com.ydz.fuckings.common.ResultCode;
import com.ydz.fuckings.controller.base.BaseController;

/**
 * 招商代理
 * @author Administrator
 *
 */
@RestController
@EnableAutoConfiguration
@RequestMapping(value="/join")  
public class JoinController extends BaseController{
	
	/**Join mapper*/
	@Autowired
	private JoinMapper joinMapper;
	
	
	/**
	 * 新增Join
	 * @param info
	 * @return
	 */
    @RequestMapping(value="/insertJoin", method=RequestMethod.POST)
	public JsonResult insertJoin(Join info)throws MyException{
		try {
			if(info.getId()==null||info.getId()==0){
				info.setCreateDate(new Date());
				joinMapper.save(info);
			}else{
				joinMapper.update(info);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new MyException(ResultCode.ERROR.msg());
		}
		return new JsonResult();
	}
	
	
	/**
	 * 查询Join 列表
	 * @return
	 */
    @RequestMapping(value="/findJoin", method=RequestMethod.POST)
    public JsonResult findAll(Integer pageNum,Integer pageSize,Join info)throws MyException{
    	Page page= PageHelper.startPage(pageNum, pageSize);
		try {
			joinMapper.findAll(info);
		} catch (Exception e) {
			throw new MyException(ResultCode.ERROR.msg()); 
		}
		return new JsonResult(new PageInfo(page)); 
	}
    
    /**
	 * 查看Join
	 * @return
	 */
    @RequestMapping(value="/findOne", method=RequestMethod.POST)
    public JsonResult findOne(Integer id)throws MyException{
    	Join info = null;
		try {
			info = joinMapper.findOne(id);
		} catch (Exception e) {
			throw new MyException(ResultCode.ERROR.msg());
		}
		return new JsonResult(info); 
	}
	
    /**
     * 删除Join
     * @param id
     * @return
     */
    @RequestMapping(value="/delete", method=RequestMethod.POST)
    public JsonResult delete(Integer id)throws MyException{
		try {
			joinMapper.delete(id);
		} catch (Exception e) {
			throw new MyException(ResultCode.ERROR.msg());
		}
		return new JsonResult(); 
	}
	
	
}
