package com.jaspa.healthtouch.center.product.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.jaspa.healthtouch.center.product.model.dto.ProductDTO;

@Mapper
public interface ProductMapper {

	// 회원권 조회
	List<ProductDTO> findAllMembership();

	// 상품 등록
	int registProduct(ProductDTO product);

	// 상품 수정을 위한 조회
	ProductDTO findModifyProduct(int proNo);

	// 상품 수정
	int updateProduct(ProductDTO product);

	// 상품 삭제
	int deleteProduct(int no);

	//PT 상품 조회
	List<ProductDTO> findAllPT();
	
	// 락커 이용권 조회
	List<ProductDTO> findAllRocker();

	// 운동복 이용권 조회
	List<ProductDTO> findAllSportswear();
	

}
