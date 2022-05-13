package com.jaspa.healthtouch.member.product.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jaspa.healthtouch.center.product.model.dto.ProductDTO;
import com.jaspa.healthtouch.login.model.dto.MemberDTO;
import com.jaspa.healthtouch.member.product.model.dao.MemberProMapper;
import com.jaspa.healthtouch.member.product.model.dto.OrderDTO;
import com.jaspa.healthtouch.member.product.model.dto.PaymentDTO;

@Service("MemberProService")
@Transactional
public class MemberProServiceImpl implements MemberProService{
	
	private MemberProMapper memberProMapper;
	
	@Autowired
	public void MemberProServiceImpl(MemberProMapper memberProMapper) {
		this.memberProMapper = memberProMapper;
	}

	@Override
	public List<ProductDTO> findAllMembership() {
		return memberProMapper.findAllMembership();
	}

	@Override
	public int insertOrder(OrderDTO order, int period) {
		
		int result = memberProMapper.insertOrder(order, period);
		
		return result;
		
	}

	@Override
	public int insertPayment(PaymentDTO payment) {
		
		int result = memberProMapper.insertPayment(payment);
		
		return result;
		
	}

	@Override
	public List<PaymentDTO> selectOrderList(String userId) {
		return memberProMapper.selectOrderList(userId);
	}

	@Override
	public List<PaymentDTO> searchOrderList(int searchOption, String userId) {
		return memberProMapper.searchOrderList(searchOption, userId);
	}

	@Override
	public List<MemberDTO> findTrainerList() {
		return memberProMapper.findTrainerList();
	}

	@Override
	public List<ProductDTO> findAllPTList() {
		return memberProMapper.findAllPTList();
	}
	

}
