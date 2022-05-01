package com.jaspa.healthtouch.notice.model.dto;

import java.util.Date;

import lombok.Data;

@Data
public class CommentDTO {
	private int commentNo;
	private int memberId;
	private int noticeNo;
	private String commentContent;
	private Date commentDate;
	private Date commentEditDate;
	private String commentDelete;
}
