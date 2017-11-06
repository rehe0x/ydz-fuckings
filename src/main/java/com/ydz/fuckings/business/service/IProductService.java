package com.ydz.fuckings.business.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ydz.fuckings.business.model.Product;
/**
 * 产品service接口
* @ClassName: IProductService 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author xieh 
* @date 2017年6月7日 下午9:53:08 
*
 */

public interface IProductService {
    Integer deleteByPrimaryKey(Integer id);

    Integer insert(Product record);

    Product selectByPrimaryKey(Integer id);

    List<Product> selectAll(Product info);

    Integer updateByPrimaryKey(Product record);
}
