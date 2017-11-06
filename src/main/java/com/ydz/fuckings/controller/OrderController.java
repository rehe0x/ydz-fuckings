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
import com.ydz.fuckings.business.model.Join;
import com.ydz.fuckings.business.model.Order;
import com.ydz.fuckings.business.service.IOrderService;
import com.ydz.fuckings.common.JsonResult;
import com.ydz.fuckings.common.MyException;
import com.ydz.fuckings.common.ResultCode;
import com.ydz.fuckings.controller.base.BaseController;

/**
 * 在线订单
 * @author Administrator
 *
 */
@RestController
@EnableAutoConfiguration
@RequestMapping(value="/order")  
public class OrderController extends BaseController{
	
	/**Order Service*/
	@Autowired
	private IOrderService iOrderService;
	
	
	/**
	 * 新增Order
	 * @param info
	 * @return
	 */
    @RequestMapping(value="/insertOrder", method=RequestMethod.POST)
	public JsonResult insertOrder(Order info)throws MyException{
		try {
			if(info.getId()==null||info.getId()==0){
				info.setCreateDate(new Date());
				info.setOrderNbr(UUID.randomUUID().toString());
				iOrderService.insert(info);
			}else{
				iOrderService.updateByPrimaryKey(info);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new MyException(ResultCode.ERROR.msg());
		}
		return new JsonResult();
	}
	
	
	/**
	 * 查询Order 列表
	 * @return
	 */
    @RequestMapping(value="/findOrder", method=RequestMethod.POST)
    public JsonResult findOrder(Integer pageNum,Integer pageSize,Order info)throws MyException{
    	Page page= PageHelper.startPage(pageNum, pageSize);
		try {
			iOrderService.selectAll(info);
		} catch (Exception e) {
			throw new MyException(ResultCode.ERROR.msg()); 
		}
		return new JsonResult(new PageInfo(page)); 
	}
    
    /**
	 * 查看Order
	 * @return
	 */
    @RequestMapping(value="/findOne", method=RequestMethod.POST)
    public JsonResult findOne(Integer id)throws MyException{
    	Order info = null;
		try {
			info = iOrderService.selectByPrimaryKey(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new MyException(ResultCode.ERROR.msg());
		}
		return new JsonResult(info); 
	}
	
    /**
     * 删除Order
     * @param id
     * @return
     */
    @RequestMapping(value="/delete", method=RequestMethod.POST)
    public JsonResult delete(Integer id)throws MyException{
		try {
			iOrderService.deleteByPrimaryKey(id);
		} catch (Exception e) {
			throw new MyException(ResultCode.ERROR.msg());
		}
		return new JsonResult(); 
	}
	
	
}
