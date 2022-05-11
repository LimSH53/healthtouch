package com.jaspa.healthtouch.member.product.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.jaspa.healthtouch.center.product.model.dto.ProductDTO;
import com.jaspa.healthtouch.member.product.model.dto.OrderDTO;
import com.jaspa.healthtouch.member.product.model.dto.PaymentDTO;

@Mapper
public interface MemberProMapper {

	// 회원권 조회 회원용
	List<ProductDTO> findAllMembership();

	// 회원 구매 등록
	int insertOrder(OrderDTO order, int period);

	// 회원 결제 정보
	int insertPayment(PaymentDTO payment);

}
