package com.ydz.fuckings.business.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ydz.fuckings.business.mapper.ProductMapper;
import com.ydz.fuckings.business.model.Product;
import com.ydz.fuckings.business.service.IProductService;

/**
 * 产品service接口实现
* @ClassName: ProductServiceImpl 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author xieh 
* @date 2017年6月7日 下午9:54:06 
*
 */
@Service
public class ProductServiceImpl implements IProductService{
	@Autowired
	private ProductMapper productMapper;
	
	@Override
	public Integer deleteByPrimaryKey(Integer id) {
		return productMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Integer insert(Product record) {
		return productMapper.insert(record);
	}

	@Override
	public Product selectByPrimaryKey(Integer id) {
		return productMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Product> selectAll(Product info) {
		return productMapper.selectAll(info);
	}

	@Override
	public Integer updateByPrimaryKey(Product record) {
		return productMapper.updateByPrimaryKey(record);
	}

}
