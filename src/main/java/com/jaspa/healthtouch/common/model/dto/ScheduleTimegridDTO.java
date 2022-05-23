package com.jaspa.healthtouch.common.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ScheduleTimegridDTO {
	private String daysOfWeek;
	private String startTime;
	private String endTime;
	private String display;
	private String backgroundColor;
	private String groupId;
}
