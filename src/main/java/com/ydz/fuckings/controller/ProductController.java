package com.ydz.fuckings.controller;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ydz.fuckings.business.model.Product;
import com.ydz.fuckings.business.service.IProductService;
import com.ydz.fuckings.common.JsonResult;
import com.ydz.fuckings.common.MyException;
import com.ydz.fuckings.common.ResultCode;
import com.ydz.fuckings.controller.base.BaseController;

/**
 * ProductController
 * @author Administrator
 *
 */
@RestController
@EnableAutoConfiguration
@RequestMapping(value="/product")  
public class ProductController extends BaseController{
	
	/**IProductService*/
	@Autowired
	private IProductService iProductService;
	
	
	/**
	 * 新增产怕
	 * @param info
	 * @return
	 * @throws MyException
	 */
    @RequestMapping(value="/insertProduct", method=RequestMethod.POST)
	public JsonResult insertProduct(Product info)throws MyException{
		try {
			if(info.getId()==null||info.getId()==0){
				info.setProductNbr(UUID.randomUUID().toString());
				info.setCreateDate(new Date());
				iProductService.insert(info);
			}else{
				iProductService.updateByPrimaryKey(info);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new MyException(ResultCode.ERROR.msg());
		}
		return new JsonResult();
	}
	
	
	/**
	 * 查询产品
	 * @return
	 */
    @RequestMapping(value="/selectProductAll", method=RequestMethod.POST)
    public JsonResult selectProductAll(Integer pageNum,Integer pageSize,Product info){
    	Page page= PageHelper.startPage(pageNum, pageSize);
		try {
			iProductService.selectAll(info);
		} catch (Exception e) {
			new MyException(ResultCode.ERROR.msg()); 
		}
		return new JsonResult(new PageInfo(page)); 
	}
    
    /**
	 * 查看
	 * @return
	 */
    @RequestMapping(value="/selectByPrimaryKey", method=RequestMethod.POST)
    public JsonResult selectByPrimaryKey(Integer id){
    	Product bean = null;
		try {
			bean = iProductService.selectByPrimaryKey(id);
		} catch (Exception e) {
			new MyException(ResultCode.ERROR.msg());
		}
		return new JsonResult(bean); 
	}
	
    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping(value="/deleteByPrimaryKey", method=RequestMethod.POST)
    public JsonResult deleteByPrimaryKey(Integer id){
		try {
			iProductService.deleteByPrimaryKey(id);
		} catch (Exception e) {
			new MyException(ResultCode.ERROR.msg());
		}
		return new JsonResult(); 
	}
	
	
}
