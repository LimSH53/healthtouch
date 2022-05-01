package com.jaspa.healthtouch.notice.model.dto;

import lombok.Data;

@Data
public class AttachmentDTO {
	private int attachNo;
	private int noticeNo;
	private String root;
	private String thumbRoot;
	private String File;
	private String editFile;
	private String fileType;
}
