package com.ydz.fuckings.business.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ydz.fuckings.business.model.Product;

@Mapper
public interface ProductMapper {
	
    Integer deleteByPrimaryKey(Integer id);

    Integer insert(Product record);

    Product selectByPrimaryKey(Integer id);

    List<Product> selectAll(Product info);

    Integer updateByPrimaryKey(Product record);
}