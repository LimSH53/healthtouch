package com.jaspa.healthtouch.common.model.dto;

import java.util.Date;

import com.jaspa.healthtouch.login.model.dto.MemberDTO;

import lombok.Data;

@Data
public class NotificationDTO {
	private int no;
	private String title;
	private String content;
	private String reqUrl;
	private Date time;
	private String readYn;
	private String memberId;
	
	private MemberDTO member;
}
