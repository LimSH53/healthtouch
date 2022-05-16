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
		/* 1.  구매 테이블에서 userId 기준으로 만료되지 않은 락커 이용권이 있는지 조회 
		 * 이용권이 있으면 이용권 번호를 리턴 => 락커 테이블에 이용권 번호까지 가지고 insert
		 * 이용권이 없으면 null 리턴 => exception 발생 시켜 락커 테이블에 insert하지 않고 이용권을 구매 한 뒤 이용하라는 안내를 view에서 한다 */
		
		lockerMapper.updateLocker(locker);
		System.out.println(locker);
	}

	/* 이용권 조회 */
	@Override
	public int selectOrdNum(int no) {
		
		int ordNum = lockerMapper.selectOrdNum(no);
		 	
		if( ordNum == 0 ) {
			return 0;
		}
		
		return ordNum;
	}

	
}
