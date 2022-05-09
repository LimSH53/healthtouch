package com.jaspa.healthtouch.notice.notice.model.dto;

import java.util.Date;

import com.jaspa.healthtouch.login.model.dto.MemberDTO;

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
	
	private MemberDTO member;
	private NoticeDTO notice;
	
}
