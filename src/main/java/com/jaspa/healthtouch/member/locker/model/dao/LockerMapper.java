package com.jaspa.healthtouch.member.locker.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.jaspa.healthtouch.member.locker.model.dto.LockerDTO;


@Mapper
public interface LockerMapper {
	
	/* 라커 전체조회 */
	List<LockerDTO> selectAllLocker();

	void updateLocker(LockerDTO locker);

	List<Map> autoComplete(Map<String, Object> paramMap)throws Exception;

	int registLocker(LockerDTO locker);

	int insertCenterLockerOrder(LockerDTO locker);

	/* 라커 등록 */
	/* int updateLocker(LockerDTO locker); */

	/* 구매내역 조회 */
	/* int selectOrdNum(int no); */

}
