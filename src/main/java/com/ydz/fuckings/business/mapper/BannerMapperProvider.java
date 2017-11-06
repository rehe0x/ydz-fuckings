package com.ydz.fuckings.business.mapper;

import org.springframework.util.StringUtils;

public class BannerMapperProvider {
	
	// 使用工具类来准备相同的 SQL 语句
    public String findBanner(String place) {
    	 String sql = "select * from yf_banner where  state='E'";
         if (StringUtils.isEmpty(place)||"0".equals(place)) {
             return sql;
         }
         sql += " and place='"+ place+"'  ";
         sql+=" order by create_date desc";
         return sql;
    }
}
