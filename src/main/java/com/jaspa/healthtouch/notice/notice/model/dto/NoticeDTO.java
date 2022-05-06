package com.jaspa.healthtouch.notice.notice.model.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class NoticeDTO {
	private int noticeNo;
	private String memberId;
	private String noticeTitle;
	private String noticeContent;
	private String noticeDelete;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date noticeDate;
	private Date noticeEditDate;
	private int noticeView;

}
 