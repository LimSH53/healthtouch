package com.jaspa.healthtouch.notice.notice.model.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaspa.healthtouch.notice.notice.model.dao.NoticeMapper;
import com.jaspa.healthtouch.notice.notice.model.dto.NoticeDTO;


@Service("noticeService")
public class NoticeServiceImpl implements NoticeService{
	
	@Autowired
	public NoticeMapper noticeMapper;
	

	@Override
	public void registNotice(NoticeDTO notice)throws Exception  {
		noticeMapper.registNotice(notice);
		
 
		}
	}
	
 
	 
	
