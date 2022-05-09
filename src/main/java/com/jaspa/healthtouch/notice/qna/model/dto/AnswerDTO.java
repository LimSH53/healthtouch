package com.jaspa.healthtouch.notice.qna.model.dto;

import java.util.Date;

import com.jaspa.healthtouch.paging.CommonDTO;

import lombok.Data; 

@Data
public class AnswerDTO extends CommonDTO {
	private int aNo;
	private int qNo;
	private String memberId;
	private String aTitle;
	private String aContent;
	private String aDelete;
	private Date aDate;
	private Date aEditDate;

}
