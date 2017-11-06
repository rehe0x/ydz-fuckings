package com.ydz.fuckings.business.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import com.ydz.fuckings.business.model.User;

/**
* 
* @author Ydz-xie
* @since 2017-05-12 23:24:49
*/
@Mapper
public interface UserMapper {

	/**
	* 保存对象
	* @author Lance
	* @since 2017-05-12 23:24:49
	*/
	@Insert("insert into yf_user(user_account,user_name,user_phone,pwd,email,img) values(#{userAccount},#{userName},#{userPhone},#{pwd},#{email},#{img})")
	Integer save(User info);

	/**
	* 修改对象
	* @author Lance
	* @since 2017-05-12 23:24:49
	*/
	Integer update(User info);

	/**
	* 删除对象
	* @author Lance
	* @since 2017-05-12 23:24:49
	*/
	Integer delete(Integer id);

	/**
	* 根据ID查询对象
	* @author Lance
	* @since 2017-05-12 23:24:49
	*/
	User findOne(Integer id);
	
	/**
	 * 根据用户账号 密码查询用户
	 * @param userAccount
	 * @param pwd
	 * @return
	 */
	@SelectProvider(type=UserMapperProvider.class,method="findByUser")
	User findByUser(String userAccount,String pwd);
	
	
	
}