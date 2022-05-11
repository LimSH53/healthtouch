package com.jaspa.healthtouch.center.member.model.service;

import java.util.List;

import com.jaspa.healthtouch.login.model.dto.MemberDTO;

public interface CenterMemberService {

	List<MemberDTO> findAllMember(MemberDTO params);

	MemberDTO getMemberDetail(String id);

	void modifyMemberType(String id);

}
