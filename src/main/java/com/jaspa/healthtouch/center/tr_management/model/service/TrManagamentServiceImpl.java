package com.jaspa.healthtouch.center.tr_management.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jaspa.healthtouch.login.model.dao.MemberMapper;
import com.jaspa.healthtouch.login.model.dto.MemberDTO;

@Service("trManagementService")
@Transactional
public class TrManagamentServiceImpl implements TrManagementService{

	private MemberMapper memberMapper;
	
	@Autowired
	public void TrManagementServiceImpl(MemberMapper memberMapper) {
		this.memberMapper = memberMapper;
	}
	
	
	@Override
	public List<MemberDTO> selectAllTrainer() {
		return memberMapper.selectAllTrainer();
	}

}
