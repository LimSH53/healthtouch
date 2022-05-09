package com.jaspa.healthtouch.center.member.model.service;

import java.util.List;

import com.jaspa.healthtouch.common.paging.Criteria;
import com.jaspa.healthtouch.login.model.dto.MemberDTO;

public interface CenterMemberService {

	List<MemberDTO> findAllMember(MemberDTO params);

}
