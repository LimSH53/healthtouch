package com.jaspa.healthtouch.member.reservation.model.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.jaspa.healthtouch.common.model.dto.CommonDTO;
import com.jaspa.healthtouch.login.model.dto.MemberDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReservationDTO extends CommonDTO {
	private int no;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date datetime;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date reqDatetime;
	private String state;
	private String type;
	private String memberId;
	private String trainerId;
	
	private MemberDTO member;
	private MemberDTO trainer;
}
