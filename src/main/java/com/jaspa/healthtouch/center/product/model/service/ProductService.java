package com.jaspa.healthtouch.center.product.model.service;

import java.util.List;

import com.jaspa.healthtouch.center.product.model.dto.ProductDTO;

public interface ProductService {

	List<ProductDTO> findAllMembership();

	boolean registProduct(ProductDTO product);
	

}
