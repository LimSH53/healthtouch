package com.jaspa.healthtouch.notice.qna.model.dto;

import java.util.Date;

import lombok.Data; 

@Data
public class QuestionDTO {
	private int qNo;
	private String memberId;
	private int categoryNo;
	private String qTitle;
	private String qContent;
	private String qDelete;
	private Date qDate;
	private Date qEditDate;

}
