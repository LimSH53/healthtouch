package com.jaspa.healthtouch.center.product.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jaspa.healthtouch.center.product.model.dao.ProductMapper;
import com.jaspa.healthtouch.center.product.model.dto.ProductDTO;

@Service("ProductService")
@Transactional
public class ProductServiceImpl implements ProductService{
	
	private ProductMapper productMapper;
	
	@Autowired
	public void ProductServiceImpl(ProductMapper productMapper) {
		this.productMapper = productMapper;
	}

	@Override
	public List<ProductDTO> findAllMembership() {
		return productMapper.findAllMembership();
	}

}
