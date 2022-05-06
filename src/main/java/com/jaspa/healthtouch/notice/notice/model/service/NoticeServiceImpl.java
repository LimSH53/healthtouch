package com.jaspa.healthtouch.notice.notice.model.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.jaspa.healthtouch.notice.notice.model.dao.NoticeMapper;
import com.jaspa.healthtouch.notice.notice.model.dto.NoticeDTO;


@Service("noticeService")
public class NoticeServiceImpl implements NoticeService{
	
	
	@Autowired
	public NoticeMapper noticeMapper;
	
		
	//공지사항 조회
	  @Override
		public List<NoticeDTO> noticeList() throws Exception {
		        return noticeMapper.noticeList();
		    }
	  
	
	//공지사항 등록
	@Override
	public void registNotice(NoticeDTO notice)throws Exception  {
		noticeMapper.registNotice(notice);
		

		}

	
	  
	 public NoticeDTO selectNoticeDetail(int noticeNo) throws Exception {
		 noticeMapper.viewCount(noticeNo);
			
		 NoticeDTO notice = noticeMapper.selectNoticeDetail(noticeNo);
			
			return notice;
	 }
	  
}
	
 
	 
	
