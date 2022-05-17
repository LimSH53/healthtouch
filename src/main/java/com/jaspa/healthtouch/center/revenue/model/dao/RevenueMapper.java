package com.jaspa.healthtouch.center.revenue.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.jaspa.healthtouch.member.product.model.dto.PaymentDTO;

@Mapper
public interface RevenueMapper {

	// 전체 매출 조회
	List<PaymentDTO> selectAllrevenue();

}
