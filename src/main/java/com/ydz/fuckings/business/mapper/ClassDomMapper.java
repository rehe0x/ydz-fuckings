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
* 
* @author xch
* @since 2017-05-13 14:38:56
*/
@Mapper
public interface ClassDomMapper {

	/**
	* 保存对象
	* @author Lance
	* @since 2017-05-13 14:38:56
	*/
	@Insert("insert into yf_class_dom(super_id,class_name) values(#{superId},#{className})")
	int save(ClassDom info)throws MyException;

	/**
	* 修改对象
	* @author xch
	* @since 2017-05-13 14:38:56
	*/
	@Update("update yf_class_dom set class_name=#{className} where id=#{id}")
	int update(ClassDom info)throws MyException;

	/**
	* 删除对象
	* @author xch
	* @since 2017-05-13 14:38:56
	*/
	@Delete("delete from yf_class_dom where id=#{id}")
	int delete(Integer id)throws MyException;

	/**
	* 根据ID查询对象
	* @author xch
	* @since 2017-05-13 14:38:56
	*/
	@Select("select * from yf_class_dom where id=#{id}")
	Map findOne(Integer id)throws MyException;
	
	/**
	* 查询所有
	* @author xch
	* @since 2017-05-13 14:38:56
	*/
	@Select("select * from yf_class_dom")
	List<Map> findAll()throws MyException;
}