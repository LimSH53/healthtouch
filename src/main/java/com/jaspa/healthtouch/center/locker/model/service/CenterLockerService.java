package com.jaspa.healthtouch.center.locker.model.service;

import java.util.List;
import java.util.Map;

import com.jaspa.healthtouch.member.locker.model.dto.LockerDTO;

public interface CenterLockerService {

	List<LockerDTO> selectAllLocker();

	List<Map>autoComplete(Map<String, Object> paramMap) throws Exception;

	void registLocker(LockerDTO locker);
}
