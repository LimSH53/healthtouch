package com.jaspa.healthtouch.member.product.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.jaspa.healthtouch.center.product.model.dto.ProductDTO;

@Mapper
public interface MemberProMapper {

	// 회원권 조회 회원용
	List<ProductDTO> findAllMembership();

}
