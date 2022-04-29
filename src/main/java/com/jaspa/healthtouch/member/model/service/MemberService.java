package com.jaspa.healthtouch.member.model.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.jaspa.healthtouch.member.model.dto.MemberDTO;

public interface MemberService extends UserDetailsService {
	
	void regist(MemberDTO member);

}
