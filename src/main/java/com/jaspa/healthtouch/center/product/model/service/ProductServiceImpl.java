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

	@Override
	public boolean registProduct(ProductDTO product) {
		
		int result = productMapper.registProduct(product);
		
		return result > 0 ? true : false;
	}

	@Override
	public ProductDTO findModifyProduct(int proNo) {
		return productMapper.findModifyProduct(proNo);
	}

	@Override
	public int updateProduct(ProductDTO product) {
		
		int result = productMapper.updateProduct(product);
		
		return result;
	}

	@Override
	public int deleteProduct(int no) {
		
		int result = productMapper.deleteProduct(no);
		
		return result;
	}

	@Override
	public List<ProductDTO> findAllPT() {
		return productMapper.findAllPT();
	}



}
