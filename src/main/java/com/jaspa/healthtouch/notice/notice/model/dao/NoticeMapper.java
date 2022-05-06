package com.jaspa.healthtouch.notice.notice.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.jaspa.healthtouch.notice.notice.model.dto.AttachmentDTO;
import com.jaspa.healthtouch.notice.notice.model.dto.NoticeDTO;

@Mapper
public interface NoticeMapper {
	
	void registNotice(NoticeDTO notice) throws Exception;
	
	
	void registNoticeFileList(List<AttachmentDTO> list) throws Exception;
	
	
}
