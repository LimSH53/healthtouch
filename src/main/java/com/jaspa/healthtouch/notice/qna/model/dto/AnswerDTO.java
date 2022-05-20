package com.jaspa.healthtouch.notice.qna.model.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.jaspa.healthtouch.login.model.dto.MemberDTO;

import lombok.Data; 

@Data
public class AnswerDTO {
	private int aNo;
	private int qNo;
	private String memberId;
	private String aTitle;
	private String aContent;
	private String aDelete;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date aDate;
	private Date aEditDate;

	private MemberDTO trainer;
	private MemberDTO member;
	private QuestionDTO question; 
}
