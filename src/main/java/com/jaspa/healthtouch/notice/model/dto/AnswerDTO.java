package com.jaspa.healthtouch.notice.model.dto;

import java.util.Date;

import lombok.Data; 

@Data
public class AnswerDTO {
	private int aNo;
	private int qNo;
	private String memberId;
	private String aTitle;
	private String aContent;
	private String aDelete;
	private Date aDate;
	private Date aEditDate;

}
