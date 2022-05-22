package com.jaspa.healthtouch.trainer.commute.model.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jaspa.healthtouch.login.model.dto.MemberRoleDTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class TrainerCmtDTO {

	
	private int no;
	private String id;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private Date attendTime;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private Date leaveTime;
	private String title;
	
	private MemberRoleDTO memberRole;
	
}
	