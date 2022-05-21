package com.jaspa.healthtouch.center.trainer.model.dto;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.jaspa.healthtouch.common.model.dto.CommonDTO;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class HolidayDTO extends CommonDTO{

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
