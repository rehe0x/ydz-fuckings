package com.ydz.fuckings.business.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ydz.fuckings.business.model.ClassDom;
import com.ydz.fuckings.common.MyException;

/**
* 区域
* @author xch
* @since 2017-05-13 14:38:56
*/
@Mapper
public interface AreaMapper {

	/**
	* 根据ID查询对象
	* @author xch
	* @since 2017-05-13 14:38:56
	*/
	@Select("select * from yf_area where id=#{id}")
	Map findOne(Integer id)throws MyException;
	
	/**
	* 查询所有
	* @author xch
	* @since 2017-05-13 14:38:56
	*/
	@Select("select * from yf_area")
	List<Map> findAll()throws MyException;
}