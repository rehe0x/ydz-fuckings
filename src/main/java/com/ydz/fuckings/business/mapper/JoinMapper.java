package com.ydz.fuckings.business.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import com.ydz.fuckings.business.model.Join;

/**
*招商代理 留言
* @author Lance
* @since 2017-05-13 14:38:56
*/
@Mapper
public interface JoinMapper {

	/**
	* 保存对象
	* @author Lance
	* @since 2017-05-13 14:38:56
	*/
	@Insert("insert into yf_join(name,email,phone,message,create_date) values(#{name},#{email},#{phone},#{message},#{createDate})")
	Integer save(Join info);

	/**
	* 修改对象
	* @author Lance
	* @since 2017-05-13 14:38:56
	*/
	
	Integer update(Join info);

	/**
	* 删除对象
	* @author Lance
	* @since 2017-05-13 14:38:56
	*/
	@Delete("delete from yf_join where id=#{id}")
	Integer delete(int id);

	/**
	* 根据ID查询对象
	* @author Lance
	* @since 2017-05-13 14:38:56
	*/
	@Select("select * from yf_join where id=#{id}")
	@Results({@Result(property = "createDate", column = "create_date")})
	Join findOne(Integer id);
	
	/**
	* 查询留言
	* @author Lance
	* @since 2017-05-13 14:38:56
	*/
	@SelectProvider(type=JoinMapperProvider.class,method="findAll")
	@Results({
        @Result(property = "name",  column = "name"),
        @Result(property = "email", column = "email"),
        @Result(property = "phone", column = "phone"),
        @Result(property = "message", column = "message"),
        @Result(property = "createDate", column = "create_date")
        
    })
	List<Join> findAll(Join info);
}