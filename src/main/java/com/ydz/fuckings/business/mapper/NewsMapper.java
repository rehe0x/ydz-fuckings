package com.ydz.fuckings.business.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ydz.fuckings.business.model.News;
import com.ydz.fuckings.common.MyException;

/**
* 
* @author xch
* @since 2017-05-13 14:38:56
*/
@Mapper
public interface NewsMapper {

	/**
	* 保存对象
	* @author Lance
	* @since 2017-05-13 14:38:56
	*/
	@Insert("insert into yf_news(news_title,news_content,create_date) values(#{newsTitle},#{newsContent},#{createDate})")
	int save(News info)throws MyException;

	/**
	* 修改对象
	* @author xch
	* @since 2017-05-13 14:38:56
	*/
	@Update("update yf_news set news_title=#{newsTitle},news_content=#{newsContent},create_date=#{createDate} where id=#{id}")
	int update(News info)throws MyException;

	/**
	* 删除对象
	* @author xch
	* @since 2017-05-13 14:38:56
	*/
	@Delete("delete from yf_news where id=#{id}")
	int delete(Integer id)throws MyException;

	/**
	* 根据ID查询对象
	* @author xch
	* @since 2017-05-13 14:38:56
	*/
	@Select("select * from yf_news where id=#{id}")
	Map findOne(Integer id)throws MyException;
	
	/**
	* 查询所有
	* @author xch
	* @since 2017-05-13 14:38:56
	*/
	@Select("select * from yf_news where 1=1 order by create_date desc")
	List<Map> findAll()throws MyException;
}