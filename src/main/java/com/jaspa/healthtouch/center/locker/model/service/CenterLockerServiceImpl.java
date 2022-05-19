package com.jaspa.healthtouch.center.locker.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaspa.healthtouch.center.trainer.model.dao.TrainerMapper;
import com.jaspa.healthtouch.member.locker.model.dao.LockerMapper;
import com.jaspa.healthtouch.member.locker.model.dto.LockerDTO;

@Service("centerLockerService")
public class CenterLockerServiceImpl implements CenterLockerService{

	private LockerMapper lockerMapper;
	
	@Autowired
	public void CenterLockerServiceImpl(LockerMapper lockerMapper) {
		this.lockerMapper = lockerMapper;
	}
	
	@Override
	public List<LockerDTO> selectAllLocker() {
	
		return lockerMapper.selectAllLocker();
	}

	@Override
	public List<Map> autoComplete(Map<String, Object> paramMap) throws Exception {
		// TODO Auto-generated method stub
		return lockerMapper.autoComplete(paramMap);
	}

	@Override
	public void registLocker(LockerDTO locker) {
		
		lockerMapper.insertCenterLockerOrder(locker);
		lockerMapper.registLocker(locker);
		
	}

}
