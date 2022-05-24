package com.jaspa.healthtouch.trainer.schedule.model.dto;

import com.jaspa.healthtouch.login.model.dto.MemberDTO;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class TrainerScheduleDTO {
	private int schNum;
	private String id;
	private String schName;
	private String schWeek;
	private int schStart;
	private int schEnd;
	private String schColor;
	
	private MemberDTO member;
}
