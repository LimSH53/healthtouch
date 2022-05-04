package com.jaspa.healthtouch.center.tr_management.model.dto;

import com.jaspa.healthtouch.login.model.dto.MemberDTO;

import lombok.Data;

@Data
public class TrainerInfoDTO {
 
	private int trNum;
	private int career;
	private String trStatus;
	private String trId;
	
	private MemberDTO member;
	
}
