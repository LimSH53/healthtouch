package com.jaspa.healthtouch.notice.notice.model.dto;

import lombok.Data;

@Data
public class AttachmentDTO {
	private int attachNo;
	private int noticeNo;
	private String root;
	private String thumbRoot;
	private String file;
	private String editFile;
	private long fileType;
}
