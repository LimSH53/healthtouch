package com.jaspa.healthtouch.center.product.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.jaspa.healthtouch.center.product.model.dto.ProductDTO;

@Mapper
public interface ProductMapper {

	List<ProductDTO> findAllMembership();


}
