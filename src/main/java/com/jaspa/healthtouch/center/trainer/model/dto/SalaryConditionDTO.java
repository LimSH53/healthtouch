package com.jaspa.healthtouch.center.trainer.model.dto;

import java.util.Date;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class SalaryConditionDTO {

	private int conditionNO;
	private int basicSalary;
	private int ptPrice;
	private int commission;
	private String conStatus;
	
	private TrainerInfoDTO trainer;
	
}
