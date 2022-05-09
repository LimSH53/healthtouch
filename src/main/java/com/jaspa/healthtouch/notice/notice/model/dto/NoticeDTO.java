package com.jaspa.healthtouch.notice.notice.model.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.jaspa.healthtouch.common.model.dto.CommonDTO;
import com.jaspa.healthtouch.login.model.dto.MemberDTO;

import lombok.Data;

@Data
public class NoticeDTO extends CommonDTO {

	private int noticeNo;
	private String memberId;
	private String noticeCategory;
	private String noticeTitle;
	private String noticeContent;
	private String noticeDelete;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date noticeDate;
	private Date noticeEditDate;
	private int noticeView;
	

	private MemberDTO member;
	
}
 