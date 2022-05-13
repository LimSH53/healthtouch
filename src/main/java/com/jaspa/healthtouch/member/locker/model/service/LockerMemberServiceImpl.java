package com.jaspa.healthtouch.member.locker.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jaspa.healthtouch.member.locker.model.dao.LockerMapper;
import com.jaspa.healthtouch.member.locker.model.dto.LockerDTO;




@Service("lockerMemberService")
@Transactional
public class LockerMemberServiceImpl implements LockerMemberService {
	private final LockerMapper lockerMapper;
	
	@Autowired
	public LockerMemberServiceImpl(LockerMapper lockerMapper) {
		this.lockerMapper = lockerMapper;
	}
	
	/* 라커 조회 */
	@Override
	public List<LockerDTO> selectAllLocker() {
		return lockerMapper.selectAllLocker();
	}

	
	/* 라커 등록 */
	@Override
	public void updateLocker(LockerDTO locker) {
		lockerMapper.updateLocker(locker);
	}


}
