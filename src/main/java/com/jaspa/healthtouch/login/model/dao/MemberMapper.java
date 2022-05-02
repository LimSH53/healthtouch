package com.jaspa.healthtouch.login.model.dao;

import org.apache.ibatis.annotations.Mapper;

import com.jaspa.healthtouch.login.model.dto.MemberDTO;
import com.jaspa.healthtouch.login.model.dto.MemberRoleDTO;

@Mapper
public interface MemberMapper {
	
	MemberDTO findMemberById(String username);
	
	void insertMember(MemberDTO member);
	
	void insertMemberRole(MemberRoleDTO memberRole);
	
}
