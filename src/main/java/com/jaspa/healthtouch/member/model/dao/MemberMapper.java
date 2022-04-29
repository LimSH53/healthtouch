package com.jaspa.healthtouch.member.model.dao;

import org.apache.ibatis.annotations.Mapper;

import com.jaspa.healthtouch.member.model.dto.MemberDTO;
import com.jaspa.healthtouch.member.model.dto.MemberRoleDTO;

@Mapper
public interface MemberMapper {
	
	MemberDTO findMemberById(String username);
	
	void insertMember(MemberDTO member);
	
	void insertMemberRole(MemberRoleDTO memberRole);
	
}
