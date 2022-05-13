package com.jaspa.healthtouch.center.trainer.model.dto;

import com.jaspa.healthtouch.login.model.dto.MemberDTO;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class TrainerInfoDTO {
 
	private int trNum;
	private int career;
	private String trStatus;
	private String trId;
	
	private MemberDTO member;
	
}
