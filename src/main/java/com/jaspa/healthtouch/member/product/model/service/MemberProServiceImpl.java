package com.jaspa.healthtouch.member.product.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jaspa.healthtouch.center.product.model.dto.ProductDTO;
import com.jaspa.healthtouch.member.product.model.dao.MemberProMapper;

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
	
	

}
