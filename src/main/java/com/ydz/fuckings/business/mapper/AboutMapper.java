package com.ydz.fuckings.business.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ydz.fuckings.business.model.About;
import com.ydz.fuckings.common.MyException;

/**
* 
* @author 
* @since 2017-05-13 14:38:56
*/
@Mapper
public interface AboutMapper {

	/**
	* 保存对象
	* @author Lance
	* @since 2017-05-13 14:38:56
	*/
	@Insert("insert into yf_about (site_weimg,service_code,copyright_title,about_title,about_content,culture_title,culture_content,product_title,product_content,site_title,slogan,site_tel,site_email"
			+ ") values(#{siteWeimg},#{serviceCode},#{copyrightTitle},#{aboutTitle},#{aboutContent},#{cultureTitle},#{cultureContent},#{productTitle},#{productContent},#{siteTitle},#{slogan},#{siteTel},#{siteEmail})")
	Integer save(About info) throws MyException;

	/**
	* 修改对象
	* @author Lance
	* @since 2017-05-13 14:38:56
	*/
	Integer update(About info);

	/**
	* 删除对象
	* @author Lance
	* @since 2017-05-13 14:38:56
	*/
	@Update("update yf_about set state='D'")
	Integer delete(Integer id);

	/**
	* 根据ID查询对象
	* @author Lance
	* @since 2017-05-13 14:38:56
	*/
	@Select("select * from yf_about where state='E' ")
	Map findOne(Integer id)throws MyException;
}