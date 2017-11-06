package com.ydz.fuckings.business.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ydz.fuckings.business.mapper.OrderMapper;
import com.ydz.fuckings.business.model.Order;
import com.ydz.fuckings.business.service.IOrderService;
import com.ydz.fuckings.common.MyException;

/**
 * 订单
* @ClassName: OrderServiceImpl 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author xieh 
* @date 2017年6月13日 下午4:47:26 
*
 */
@Service
public class OrderServiceImpl implements IOrderService{
	
	/**订单DAO*/
	@Autowired
	private OrderMapper orderMapper;
	
	@Override
	public Integer deleteByPrimaryKey(Integer id)throws MyException {
		return orderMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Integer insert(Order record)throws MyException {
		return orderMapper.insert(record);
	}

	@Override
	public Order selectByPrimaryKey(Integer id)throws MyException {
		return orderMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Order> selectAll(Order record)throws MyException {
		return orderMapper.selectAll(record);
	}

	@Override
	public Integer updateByPrimaryKey(Order record)throws MyException {
		return orderMapper.updateByPrimaryKey(record);
	}
	
}
