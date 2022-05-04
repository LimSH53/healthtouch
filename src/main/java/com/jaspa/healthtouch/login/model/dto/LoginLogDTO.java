package com.jaspa.healthtouch.login.model.dto;

import java.util.Date;

import lombok.Data;

@Data
public class LoginLogDTO {
	private int logNo;
	private String memberId;
	private Date dateTime;
	private String ip;
}
