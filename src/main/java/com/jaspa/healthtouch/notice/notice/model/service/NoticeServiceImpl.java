package com.jaspa.healthtouch.notice.notice.model.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.jaspa.healthtouch.notice.notice.model.dao.NoticeMapper;
import com.jaspa.healthtouch.notice.notice.model.dto.AttachmentDTO;
import com.jaspa.healthtouch.notice.notice.model.dto.FileUtils;
import com.jaspa.healthtouch.notice.notice.model.dto.NoticeDTO;


@Service("noticeService")
public class NoticeServiceImpl implements NoticeService{
	
	@Autowired
	public NoticeMapper noticeMapper;
	
	@Autowired
	private FileUtils fileUtils;   
	

	@Override
	public void registNotice(NoticeDTO notice, MultipartHttpServletRequest multipartHttpServletRequest)throws Exception  {
		noticeMapper.registNotice(notice);
		
		List<AttachmentDTO> list = fileUtils.parseFileInfo(notice.getNoticeNo(), multipartHttpServletRequest);
		if(CollectionUtils.isEmpty(list) == false) {
			noticeMapper.registNoticeFileList(list);
		}
	}
	
}
 
	 
	
