package com.jaspa.healthtouch.notice.notice.model.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaspa.healthtouch.common.paging.PaginationInfo;
import com.jaspa.healthtouch.login.model.dao.MemberMapper;
import com.jaspa.healthtouch.notice.notice.model.dao.NoticeMapper;
import com.jaspa.healthtouch.notice.notice.model.dto.AttachmentDTO;
import com.jaspa.healthtouch.notice.notice.model.dto.NoticeDTO;



@Service("noticeService")
public class NoticeServiceImpl implements NoticeService{
private final NoticeMapper noticeMapper;
	
	@Autowired
	public NoticeServiceImpl(NoticeMapper noticeMapper) {
		this.noticeMapper = noticeMapper;
	}
	//공지사항 조회
	  @Override
		public List<NoticeDTO> noticeList(NoticeDTO params){
		  List<NoticeDTO> noticeList = Collections.emptyList();
		  
		  int noticeTotalCount = noticeMapper.noticeFind(params);
		  	PaginationInfo paginationInfo = new PaginationInfo(params);
			paginationInfo.setTotalRecordCount(noticeTotalCount);
			params.setPaginationInfo(paginationInfo);
			
			if(noticeTotalCount > 0) {
				noticeList = noticeMapper.noticeList(params);
			}
			
			return noticeList;
		    }	  
	
	//공지사항 상세조회
	  @Override
	  public NoticeDTO selectNoticeDetail(int noticeNo) {
			 noticeMapper.viewCount(noticeNo);
				
			 NoticeDTO notice = noticeMapper.selectNoticeDetail(noticeNo);
				
				return notice;
		 }
	  
	//공지사항 등록
	@Override
	public int registNotice(NoticeDTO notice){
		return noticeMapper.registNotice(notice);
		

		}
	

	//공지사항 수정
	@Override
	public int modifyNotice(NoticeDTO notice){
		return noticeMapper.modifyNotice(notice);
		

		}
	
	//공지사항 삭제
		@Override
		public boolean deleteNotice(int noticeNo){
			int queryResult = 0;
			NoticeDTO notice = noticeMapper.selectNoticeDetail(noticeNo);
			
			if ( notice != null && "N".equals(notice.getNoticeDelete()) ) {
				  queryResult = noticeMapper.deleteNotice(noticeNo);
				 }
			 
			 return (queryResult == 1) ? true : false;
		}
			

			}
	
	
 
	 
	
