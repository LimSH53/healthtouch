package com.jaspa.healthtouch.center.trainer.model.dto;


import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class TrainerSalaryDTO {

	private int salNo;
	@DateTimeFormat(pattern="yyyy-MM")
	private Date salDate;
	private int ptCount;
	private int totalSalary;
	
	private SalaryConditionDTO salCondition;
	
	
}
