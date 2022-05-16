package com.jaspa.healthtouch.member.locker.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.jaspa.healthtouch.member.locker.model.dto.LockerDTO;


@Mapper
public interface LockerMapper {
	
	/* 라커 전체조회 */
	List<LockerDTO> selectAllLocker();
	
	/* 라커 등록 */
	int updateLocker(LockerDTO locker);
	
	/* 구매내역 조회 */
	int selectOrdNum(int no);

}
