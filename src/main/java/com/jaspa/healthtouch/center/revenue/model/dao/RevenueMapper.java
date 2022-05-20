package com.jaspa.healthtouch.center.revenue.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.jaspa.healthtouch.member.product.model.dto.PaymentDTO;

@Mapper
public interface RevenueMapper {
	
	// 페이징 처리를 위한 매출 전체 수 조회
		int selectAllrevenueTotalCount(PaymentDTO params);

	// 전체 매출 조회
	List<PaymentDTO> selectAllrevenue(PaymentDTO params);

	// 페이징 처리를 위한 조회 전체 수 (상품별 조회)
	int selectProRevenueTotalCount(PaymentDTO params);

	// 상품별 매출 조회
	List<PaymentDTO> selectProRevenue(PaymentDTO params);

}
