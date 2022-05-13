package com.jaspa.healthtouch.center.member.model.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jaspa.healthtouch.common.paging.PaginationInfo;
import com.jaspa.healthtouch.login.model.dao.MemberMapper;
import com.jaspa.healthtouch.login.model.dto.MemberDTO;
import com.jaspa.healthtouch.member.product.model.dto.OrderDTO;

@Service("centerMemberService")
public class CenterMemberServiceImpl implements CenterMemberService {
	private final MemberMapper memberMapper;
	
	@Autowired
	public CenterMemberServiceImpl(MemberMapper memberMapper) {
		this.memberMapper = memberMapper;
	}

	@Override
	public List<MemberDTO> findAllMember(MemberDTO params) {
		List<MemberDTO> memberList = Collections.emptyList();
		
		int memberTotalCount = memberMapper.findAllMemberTotalCount(params);
		
		PaginationInfo paginationInfo = new PaginationInfo(params);
		paginationInfo.setTotalRecordCount(memberTotalCount);
		
		params.setPaginationInfo(paginationInfo);
		
		if(memberTotalCount > 0) {
			memberList = memberMapper.findAllMember(params);
		}
		
		return memberList;
	}

	@Override
	public MemberDTO getMemberDetail(String id) {
		return memberMapper.findMemberById(id);
	}

	@Transactional
	@Override
	public void modifyMemberType(String id) {
		memberMapper.modifyMemberType(id);
	}

	@Override
	public List<OrderDTO> selectOrderListById(String id) {
		return memberMapper.selectOrderListById(id);
	}

	@Transactional
	@Override
	public int modifyPeriod(String proNo, String modEndDate, String memberId) {
		return memberMapper.modifyPeriod(proNo, modEndDate, memberId);
	}

	@Override
	public String selectProductNo(String categoryNo, String memberId) {
		return memberMapper.selectProductNo(categoryNo, memberId);
	}

}
