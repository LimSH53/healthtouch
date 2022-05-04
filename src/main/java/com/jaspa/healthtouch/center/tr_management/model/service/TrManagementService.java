package com.jaspa.healthtouch.center.tr_management.model.service;

import java.util.List;

import com.jaspa.healthtouch.center.tr_management.model.dto.TrainerInfoDTO;
import com.jaspa.healthtouch.login.model.dto.MemberDTO;

public interface TrManagementService {

	List<TrainerInfoDTO> selectAllTrainer();
} 
