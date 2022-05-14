package com.jaspa.healthtouch.center.trainer.model.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class HolidayDTO {

	private int hReqNo;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date reqHday;
	private String hReason;
	private String hStatus;
	private String rejReason;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date hDay;
	
	private TrainerInfoDTO trainer;
}
