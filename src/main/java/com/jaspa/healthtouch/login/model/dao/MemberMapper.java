package com.jaspa.healthtouch.login.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.jaspa.healthtouch.login.model.dto.LoginLogDTO;
import com.jaspa.healthtouch.login.model.dto.MemberDTO;
import com.jaspa.healthtouch.login.model.dto.MemberRoleDTO;

@Mapper
public interface MemberMapper {
	
	MemberDTO findMemberById(String username);
	
	void insertMember(MemberDTO member);
	
	void insertMemberRole(MemberRoleDTO memberRole);

	int checkId(String memberId);

	int isExistContact(String phoneNumber);

	String searchId(MemberDTO member);

	void insertLoginLog(LoginLogDTO loginLog);

	int searchPwd(MemberDTO member);

	void modifyPwd(MemberDTO member);

	void modify(MemberDTO member);

	String selectEncryptedPwd(String id);

	void removeMember(String id);

	List<MemberDTO> findAllMember(MemberDTO params);
	
	int findAllMemberTotalCount(MemberDTO params);

}
