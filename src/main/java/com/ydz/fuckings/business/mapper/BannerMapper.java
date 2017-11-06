package com.ydz.fuckings.business.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import com.ydz.fuckings.business.model.Banner;
import com.ydz.fuckings.common.MyException;

/**
* 
* @author Lance
* @since 2017-05-13 14:38:56
*/
@Mapper
public interface BannerMapper {

	/**
	* 保存对象
	* @author Lance
	* @since 2017-05-13 14:38:56
	*/
	@Insert("insert into yf_banner(title,img,url,place,type,create_date) values(#{title},#{img},#{url},#{place},#{type},#{createDate})")
	int save(Banner info)throws MyException;

	/**
	* 修改对象
	* @author Lance
	* @since 2017-05-13 14:38:56
	*/
	@Update("update yf_banner set title=#{title},img=#{img},url=#{url},place=${place} where id=#{id}")
	int update(Banner info);

	/**
	* 删除对象
	* @author Lance
	* @since 2017-05-13 14:38:56
	*/
	@Delete("delete from yf_banner where id=#{id}")
	int delete(int id);

	/**
	* 根据ID查询对象
	* @author Lance
	* @since 2017-05-13 14:38:56
	*/
	@Select("select * from yf_banner where id=#{id}")
	Map findOne(Integer id)throws Exception;
	
	/**
	* 根据位置查询banner
	* @author Lance
	* @since 2017-05-13 14:38:56
	*/
	@SelectProvider(type=BannerMapperProvider.class,method="findBanner")
	List<Map> findBanner(String place)throws Exception;
}