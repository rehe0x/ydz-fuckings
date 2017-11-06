package com.ydz.fuckings.business.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.ydz.fuckings.business.model.LotteryClass;

/**
* 
* @author Lance
* @since 2017-05-13 12:32:37
*/
@Mapper
public interface LotteryClassMapper {

	/**
	* 保存对象
	* @author Lance
	* @since 2017-05-13 12:32:37
	*/
    @Insert("insert into yf_lottery_class(caipiaoid,name,parentid) values(#{caipiaoid},#{name},#{parentid})")
	Integer save(@Param("caipiaoid")Integer caipiaoid,@Param("name")String name,@Param("parentid")String parentid);

	/**
	* 修改对象
	* @author Lance
	* @since 2017-05-13 12:32:37
	*/
    Integer update(LotteryClass info);

	/**
	* 删除对象
	* @author Lance
	* @since 2017-05-13 12:32:37
	*/
    Integer delete(int id);

	/**
	* 根据ID查询对象
	* @author Lance
	* @since 2017-05-13 12:32:37
	*/
	LotteryClass findOne(int id);
	
	/**
	 * 查询所有彩票分类
	 * @return
	 */
	@Select("select caipiaoid,name,parentid from yf_lottery_class")
	List<LotteryClass> findAll();
	
	
}