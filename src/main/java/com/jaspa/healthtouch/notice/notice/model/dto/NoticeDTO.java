package com.jaspa.healthtouch.notice.notice.model.dto;

import java.util.Date;


import lombok.Data;

@Data
public class NoticeDTO {
	private int noticeNo;
	private String memberId;
	private String noticeTitle;
	private String noticeContent;
	private String noticeDelete;
	private Date noticeDate;
	private Date noticeEditDate;
	private int noticeView;

}
 