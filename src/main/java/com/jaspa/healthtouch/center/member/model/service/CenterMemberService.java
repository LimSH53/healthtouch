package com.jaspa.healthtouch.center.member.model.service;

import java.util.List;

import com.jaspa.healthtouch.login.model.dto.MemberDTO;
import com.jaspa.healthtouch.member.product.model.dto.OrderDTO;

public interface CenterMemberService {

	List<MemberDTO> findAllMember(MemberDTO params);

	MemberDTO getMemberDetail(String id);

	void modifyMemberType(String id);

	List<OrderDTO> selectOrderListById(String id);

	int modifyPeriod(String proNo, String modEndDate, String memberId);

	String selectProductNo(String categoryNo, String memberId);

}
