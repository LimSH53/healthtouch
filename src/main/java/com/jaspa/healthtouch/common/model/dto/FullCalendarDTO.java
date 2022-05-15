package com.jaspa.healthtouch.common.model.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FullCalendarDTO {
	private String title;
	@DateTimeFormat(pattern="yyyy-MM-dd[THH:MM:SS]")
	private Date start;
	private boolean allDay;
}
