package com.jaspa.healthtouch.member.product.model.service;

import java.util.List;

import com.jaspa.healthtouch.center.product.model.dto.ProductDTO;

public interface MemberProService {

	// 회원 회원권 상품 조회
	List<ProductDTO> findAllMembership();
	
	

}
