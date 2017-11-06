package com.ydz.fuckings.business.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.ydz.fuckings.business.model.LotteryOrder;

/**
* 
* @author Lance
* @since 2017-05-13 14:38:56
*/
@Mapper
public interface LotteryOrderMapper {

	/**
	* 保存对象
	* @author Lance
	* @since 2017-05-13 14:38:56
	*/
	@Insert("insert into yf_lottery_order(order_nbr,caipiaoid,lottery_nbr,lottery_num,user_id,carded,phone,order_money,create_date) "
			+ "values(#{orderNbr},#{caipiaoid},#{lotteryNbr},#{lotteryNum},#{userId},#{carded},#{phone},#{orderMoney},#{createDate})")
	int save(LotteryOrder info);
	
	/**
	* 根据userId查询对象
	* @author Lance
	* @since 2017-05-13 14:38:56
	*/
	@Select("select order_nbr,caipiaoid,lottery_nbr,lottery_num,carded,phone,create_date from yf_lottery_order where user_id=#{userId}")
	List<Map> findByUser(Integer userId);

	/**
	* 修改对象
	* @author Lance
	* @since 2017-05-13 14:38:56
	*/
	int update(LotteryOrder info);

	/**
	* 删除对象
	* @author Lance
	* @since 2017-05-13 14:38:56
	*/
	int delete(int id);

	/**
	* 根据ID查询对象
	* @author Lance
	* @since 2017-05-13 14:38:56
	*/
	LotteryOrder findOne(int id);
}