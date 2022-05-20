package com.jaspa.healthtouch.notice.notice.model.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.jaspa.healthtouch.login.model.dto.MemberDTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class CommentDTO {
	private int cmtNo;
	private String memberId;
	private int noticeNo;
	private String cmtContent;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date cmtDate;
	private Date cmtEditDate;
	private String cmtDelete;
	
	private MemberDTO member;
	private NoticeDTO notice;
} 
  