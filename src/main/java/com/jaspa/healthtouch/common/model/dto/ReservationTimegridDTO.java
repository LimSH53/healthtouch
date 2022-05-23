package com.jaspa.healthtouch.common.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReservationTimegridDTO {
	private String start;
	private String end;
	private String display;
	private String backgroundColor;
	private String groupId;
}
