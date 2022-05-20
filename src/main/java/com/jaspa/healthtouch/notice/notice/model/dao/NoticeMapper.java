package com.jaspa.healthtouch.notice.notice.model.dao;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.jaspa.healthtouch.notice.notice.model.dto.CommentDTO;
import com.jaspa.healthtouch.notice.notice.model.dto.NoticeDTO;


@Mapper
public interface NoticeMapper {
	 
	 
	//공지사항 조회
	List<NoticeDTO> noticeList(NoticeDTO params);
	 
	
	//공지사항 조회
	int noticeFind(NoticeDTO params);
	 
	  
	//공지사항 상세조회
	NoticeDTO selectNoticeDetail(int noticeNo);
	
	//공지사항 조회수
	void viewCount(int noticeNo);
	  
	//공지사항 등록 
	int registNotice(NoticeDTO notice)throws Exception;
	
	
	//공지사항 수정  
	void modifyNotice(NoticeDTO notice)throws Exception;
	
	//공지사항 삭제
	int deleteNotice(int noticeNo);
	
	
	//공지사항 댓글목록
	int commentCount() throws Exception;
	
	//공지사항 댓글목록
	List<CommentDTO>commentList(int noticeNo) throws Exception;
	
	//공지사항 댓글등록
	int registComment(CommentDTO comment) throws Exception;
	
	//공지사항 댓글수정
	int modifyComment(CommentDTO comment) throws Exception;
	
	//공지사항 댓글삭제
	int deleteComment(int cmtNo)throws Exception;
	
	
}
 