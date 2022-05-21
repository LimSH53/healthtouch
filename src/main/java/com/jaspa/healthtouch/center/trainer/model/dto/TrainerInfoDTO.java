package com.jaspa.healthtouch.center.trainer.model.dto;

import java.util.Date;

import com.jaspa.healthtouch.common.model.dto.CommonDTO;
import com.jaspa.healthtouch.login.model.dto.MemberDTO;
import com.jaspa.healthtouch.login.model.dto.MemberRoleDTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Data
public class TrainerInfoDTO extends CommonDTO{
 
	private int trNum;
	private int career;
	private String trStatus;
	private String trId;
	
	private MemberDTO member;

	
}
