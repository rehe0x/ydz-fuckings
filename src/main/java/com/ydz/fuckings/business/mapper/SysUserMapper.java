package com.ydz.fuckings.business.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import com.ydz.fuckings.business.model.SysUser;

/**
* 
* @author Ydz-xie
* @since 2017-05-12 23:24:49
*/
@Mapper
public interface SysUserMapper {

	/**
	* 保存对象
	* @author Lance
	* @since 2017-05-12 23:24:49
	*/
	@Insert("insert into yf_sys_user(name,account,pwd,create_date) values(#{name},#{account},#{pwd},#{createDate})")
	Integer save(SysUser info);

	/**
	* 修改对象
	* @author Lance
	* @since 2017-05-12 23:24:49
	*/
	@Update("update yf_sys_user set name=#{name},account=#{account} where id=#{id}")
	Integer update(SysUser info);

	/**
	* 删除对象
	* @author Lance
	* @since 2017-05-12 23:24:49
	*/
	@Delete("delete from yf_sys_user where id=#{id}")
	Integer delete(Integer id);

	/**
	* 根据ID查询对象
	* @author Lance
	* @since 2017-05-12 23:24:49
	*/
	@Select("select * from yf_sys_user where id=#{id}")
	@Results({
        @Result(property = "createDate", column = "create_date")
    })
	SysUser findOne(Integer id);
	
	/**
	 * 根据用户账号 密码查询用户
	 * @param 
	 * @param 
	 * @return
	 */
	@SelectProvider(type=UserMapperProvider.class,method="findBySysUser")
	SysUser findBySysUser(String account,String pwd);
	/**
	 * 根据账号查询
	 * @param account
	 * @return
	 */
	@Select("select * from yf_sys_user where account=#{account}")
	SysUser findBySysUserAccount(String account);
	/**
	 * 根据账号密码查询
	 * @param account
	 * @param pwd
	 * @return
	 */
	@Select("select * from yf_sys_user where account=#{account} and pwd=#{pwd}")
	SysUser findBySysUserAccountPwd(@Param("account")String account,@Param("pwd")String pwd);
	
	/**
	 * 分页查询系统用户
	 * @param info
	 * @return
	 */
	@Select("select * from yf_sys_user")
	@Results({
        @Result(property = "createDate", column = "create_date")
    })
	List<SysUser> findAll(SysUser info);
	
}