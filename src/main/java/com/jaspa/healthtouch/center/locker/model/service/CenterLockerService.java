package com.jaspa.healthtouch.center.locker.model.service;

import java.util.List;

import com.jaspa.healthtouch.member.locker.model.dto.LockerDTO;

public interface CenterLockerService {

	List<LockerDTO> selectAllLocker();

}
