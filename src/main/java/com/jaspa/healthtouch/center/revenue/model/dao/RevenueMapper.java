package com.jaspa.healthtouch.center.revenue.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.jaspa.healthtouch.member.product.model.dto.PaymentDTO;

@Mapper
public interface RevenueMapper {

	// 전체 매출 조회
	List<PaymentDTO> selectAllrevenue(PaymentDTO params);

	// 페이징 처리를 위한 매출 전체 수 조회
	int selectAllrevenueTotalCount(PaymentDTO params);

}
