package com.jaspa.healthtouch.center.revenue.model.service;

import java.util.List;

import com.jaspa.healthtouch.member.product.model.dto.PaymentDTO;

public interface RevenueService {

	// 전체 매출 조회
	List<PaymentDTO> selectAllrevenue(PaymentDTO params);

	// 상품별 매출 조회
	List<PaymentDTO> selectProRevenue(PaymentDTO params);

}
