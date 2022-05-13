package com.jaspa.healthtouch.member.locker.model.service;

import java.util.List;

import com.jaspa.healthtouch.member.locker.model.dto.LockerDTO;

public interface LockerMemberService {

	
	/* 라커 전체조회 */
	List<LockerDTO> selectAllLocker();
	
	/* 라커 등록 */
	void updateLocker(LockerDTO locker);
}
