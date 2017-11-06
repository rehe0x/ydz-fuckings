package com.ydz.fuckings.business.service;

import java.util.List;

import com.ydz.fuckings.business.model.Order;
import com.ydz.fuckings.common.MyException;
/**
 * 订单
* @ClassName: IOrderService 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author xieh 
* @date 2017年6月13日 下午4:46:20 
*
 */
public interface IOrderService {
	/**删除*/
    Integer deleteByPrimaryKey(Integer id)throws MyException;

    /**保存*/
    Integer insert(Order record)throws MyException;

    /**查看*/
    Order selectByPrimaryKey(Integer id)throws MyException;

    /**分页查询*/
    List<Order> selectAll(Order record)throws MyException;

    /**修改*/
    Integer updateByPrimaryKey(Order record)throws MyException;
}
