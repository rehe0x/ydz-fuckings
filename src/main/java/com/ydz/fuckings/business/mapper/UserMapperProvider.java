package com.ydz.fuckings.business.mapper;

import org.springframework.util.StringUtils;

public class UserMapperProvider {
	
	// 使用工具类来准备相同的 SQL 语句
    public String findByUser(String userAccount,String pwd) {
    	 String sql = "select * from yf_user where user_account='"+userAccount+"' ";
         if (StringUtils.isEmpty(pwd)) {
             return sql;
         }
         sql += " and pwd='"+pwd+"' ";
         return sql;
    }
    
 // 使用工具类来准备相同的 SQL 语句
    public String findBySysUser(String account,String pwd) {
    	 String sql = "select * from yf_sys_user where account='"+account+"' ";
         if (StringUtils.isEmpty(pwd)) {
             return sql;
         }
         sql += " and pwd='"+pwd+"' ";
         return sql;
    }
}
