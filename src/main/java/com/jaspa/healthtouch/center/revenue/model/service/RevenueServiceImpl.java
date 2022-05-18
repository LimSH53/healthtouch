package com.jaspa.healthtouch.center.revenue.model.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jaspa.healthtouch.center.revenue.model.dao.RevenueMapper;
import com.jaspa.healthtouch.common.paging.PaginationInfo;
import com.jaspa.healthtouch.member.product.model.dto.PaymentDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("RevenueService")
@Transactional
public class RevenueServiceImpl implements RevenueService{
	
	private RevenueMapper revenueMapper;
	
	@Autowired
	public RevenueServiceImpl(RevenueMapper revenueMapper) {
		this.revenueMapper = revenueMapper;
	}

	@Override
	public List<PaymentDTO> selectAllrevenue(PaymentDTO params) {
		List<PaymentDTO> revenueList = Collections.emptyList();
		
		int revenueTotalCount = revenueMapper.selectAllrevenueTotalCount(params);
		
		log.info("revenueTotalCount :{}", revenueTotalCount);
		
		PaginationInfo paginationInfo = new PaginationInfo(params);
		paginationInfo.setTotalRecordCount(revenueTotalCount);
		
		params.setPaginationInfo(paginationInfo);
		
		if(revenueTotalCount > 0) {
			revenueList = revenueMapper.selectAllrevenue(params);
			log.info("업데이트 된 revenueList:{}", revenueList);
		}
		
		return revenueList;
	}

}
