package com.jaspa.healthtouch.center.product.model.service;

import java.util.List;

import com.jaspa.healthtouch.center.product.model.dto.ProductDTO;

public interface ProductService {

	List<ProductDTO> findAllMembership();

	boolean registProduct(ProductDTO product);

	ProductDTO findModifyProduct(int proNo);

	int updateProduct(ProductDTO product);

	int deleteProduct(int no);

	List<ProductDTO> findAllPT();

	List<ProductDTO> findAllRocker();

	List<ProductDTO> findAllSportswear();
	

}
