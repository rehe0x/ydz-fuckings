package com.ydz.fuckings.business.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ydz.fuckings.business.model.Order;
import com.ydz.fuckings.common.MyException;

/**
 * 订单
* @ClassName: OrderMapper 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author xieh 
* @date 2017年6月13日 下午3:52:14 
*
 */
@Mapper
public interface OrderMapper {
	
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