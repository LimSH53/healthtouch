package com.jaspa.healthtouch.member.product.model.service;

import java.util.List;

import com.jaspa.healthtouch.center.product.model.dto.ProductDTO;
import com.jaspa.healthtouch.member.product.model.dto.OrderDTO;
import com.jaspa.healthtouch.member.product.model.dto.PaymentDTO;

public interface MemberProService {

	// 회원 회원권 상품 조회
	List<ProductDTO> findAllMembership();

	// 회원 구매 등록
	int insertOrder(OrderDTO order, int period);
	
	// 회원 결제 정보
	int insertPayment(PaymentDTO payment);
	

}
