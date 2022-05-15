package com.jaspa.healthtouch.center.trainer.model.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.jaspa.healthtouch.login.model.dto.MemberDTO;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class AttendanceDTO {

	private int attNo;
	private MemberDTO member;
	@DateTimeFormat(pattern="yyyy-MM-dd 'T'HH:mm:ss")
	private Date attendTime;
	@DateTimeFormat(pattern="yyyy-MM-dd 'T'HH:mm:ss")
	private Date leaveTime;
	private String attKind;
	
}
