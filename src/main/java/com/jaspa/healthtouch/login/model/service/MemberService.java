package com.jaspa.healthtouch.login.model.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.jaspa.healthtouch.login.model.dto.LoginLogDTO;
import com.jaspa.healthtouch.login.model.dto.MemberDTO;

public interface MemberService extends UserDetailsService {
	
	void regist(MemberDTO member);

	int checkId(String memberId);

	void certifiedPhoneNumnber(String phoneNumber, String numStr);

	int isExistContact(String phoneNumber);

	String searchId(MemberDTO member);

	void createLoginLog(LoginLogDTO loginLog);

}
