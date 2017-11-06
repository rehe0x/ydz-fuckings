package com.ydz.fuckings.business.mapper;

import org.springframework.util.StringUtils;

import com.ydz.fuckings.business.model.Join;

public class JoinMapperProvider {
	
	// 使用工具类来准备相同的 SQL 语句
    public String findAll(Join info) {
    	 String sql = "select * from yf_join where 1=1";
         if (!StringUtils.isEmpty(info.getPhone())) {
        	 sql += " and phone like'%"+info.getPhone()+"%' ";
         }
         if (!StringUtils.isEmpty(info.getName())) {
        	 sql += " and name like'%"+info.getName()+"%' ";
         }
         sql+=" order by create_date desc";
        return sql;
    }
}
