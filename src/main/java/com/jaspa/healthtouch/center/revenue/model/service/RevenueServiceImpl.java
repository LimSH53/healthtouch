package com.jaspa.healthtouch.center.revenue.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jaspa.healthtouch.center.revenue.model.dao.RevenueMapper;
import com.jaspa.healthtouch.member.product.model.dto.PaymentDTO;

@Service("RevenueService")
@Transactional
public class RevenueServiceImpl implements RevenueService{
	
	private RevenueMapper revenueMapper;
	
	@Autowired
	public RevenueServiceImpl(RevenueMapper revenueMapper) {
		this.revenueMapper = revenueMapper;
	}

	@Override
	public List<PaymentDTO> selectAllrevenue() {
		return revenueMapper.selectAllrevenue();
	}

}
