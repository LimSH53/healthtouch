package com.jaspa.healthtouch.notice.notice.model.service;



import java.util.Collections;
import java.util.List;

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
	
	  @Override
	public List<NoticeDTO> noticeList() throws Exception {
		  List<NoticeDTO> noticeList = Collections.emptyList();
		  
		  int noticeTotalCount = noticeMapper.selectNoticeTotalCount();

		  if(noticeTotalCount > 0) {
			  noticeList = noticeMapper.noticeList();
			  }
		  
	        return noticeList();
	    }
	
	  
	 public NoticeDTO selectBoardDetail(int noticeNo) throws Exception {
		 noticeMapper.viewCount(noticeNo);
			
		 NoticeDTO notice = noticeMapper.selectBoardDetail(noticeNo);
			
			return notice;
	 }
	  
}
	
 
	 
	
