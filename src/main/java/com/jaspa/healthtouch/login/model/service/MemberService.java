package com.jaspa.healthtouch.login.model.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.jaspa.healthtouch.login.model.dto.LoginLogDTO;
import com.jaspa.healthtouch.login.model.dto.MemberDTO;
import com.jaspa.healthtouch.login.model.dto.UserImpl;
import com.jaspa.healthtouch.member.product.model.dto.OrderDTO;

public interface MemberService extends UserDetailsService {
	
	void regist(MemberDTO member);

	int checkId(String memberId);

	void certifiedPhoneNumnber(String phoneNumber, String numStr);

	int isExistContact(String phoneNumber);

	String searchId(MemberDTO member);

	void createLoginLog(LoginLogDTO loginLog);

	int searchPwd(MemberDTO member);

	void sendTempPwd(MemberDTO member, StringBuffer sb);

	void setTempPwd(MemberDTO member, StringBuffer sb);

	void modify(MemberDTO member);

	int modifyPwd(MemberDTO requestMember, String pwd);

	void removeMember(String id);

	void selectOrderListById(UserImpl user);

}