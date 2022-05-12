package com.jaspa.healthtouch.member.reservation.model.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.jaspa.healthtouch.common.model.dto.CommonDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReservationChangeDTO extends CommonDTO {
	private int no;
	private int rsvNo;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date reqDatetime;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date datetime;
	private String state;
	
	private ReservationDTO reservation;
}
