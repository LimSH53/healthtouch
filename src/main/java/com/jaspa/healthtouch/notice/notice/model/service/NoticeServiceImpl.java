package com.jaspa.healthtouch.notice.notice.model.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.jaspa.healthtouch.notice.notice.model.dao.NoticeMapper;
import com.jaspa.healthtouch.notice.notice.model.dto.AttachmentDTO;
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
	
	//공지사항 상세조회
	  @Override
	  public NoticeDTO selectNoticeDetail(int noticeNo) throws Exception {
			 noticeMapper.viewCount(noticeNo);
				
			 NoticeDTO notice = noticeMapper.selectNoticeDetail(noticeNo);
				
				return notice;
		 }
	  
	//공지사항 등록
	@Override
	public int registNotice(NoticeDTO notice)throws Exception  {
		return noticeMapper.registNotice(notice);
		

		}
	
	//공시사항 파일 등록(파일 업로드)
	@Override
	public int insertFile(AttachmentDTO file) throws Exception{
		return noticeMapper.insertFile(file);
	}
	
	//공시사항 파일 등록(파일 다운로드)
	@Override
	public AttachmentDTO fileDetail(int noticeNo)throws Exception{
		return noticeMapper.fileDetail(noticeNo);
	}
	
	//공지사항 수정
	@Override
	public int modifyNotice(NoticeDTO notice)throws Exception  {
		return noticeMapper.modifyNotice(notice);
		

		}
	
	//공지사항 삭제
		@Override
		public boolean deleteNotice(int noticeNo)throws Exception  {
			int queryResult = 0;
			NoticeDTO notice = noticeMapper.selectNoticeDetail(noticeNo);
			
			if ( notice != null && "N".equals(notice.getNoticeDelete()) ) {
				  queryResult = noticeMapper.deleteNotice(noticeNo);
				 }
			 
			 return (queryResult == 1) ? true : false;
		}
			

			}
	
	
 
	 
	
