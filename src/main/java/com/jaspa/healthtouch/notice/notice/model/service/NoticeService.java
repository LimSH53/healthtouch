package com.jaspa.healthtouch.notice.notice.model.service;

import java.util.List;

import com.jaspa.healthtouch.notice.notice.model.dto.CommentDTO;
import com.jaspa.healthtouch.notice.notice.model.dto.NoticeDTO;


public interface NoticeService {
		
		//공지사항 조회
		List<NoticeDTO> noticeList(NoticeDTO params);
		 
		//공지사항 상세 
		NoticeDTO selectNoticeDetail(int noticeNo);
		 
		//공지사항 등록
		int registNotice(NoticeDTO notice)throws Exception;
		
		//공지사항 수정  
		void modifyNotice(NoticeDTO notice)throws Exception;
		
		//공지사항 삭제
		boolean deleteNotice(int noticeNo);

		//공지사항 댓글목록
		List<CommentDTO> commentList(int noticeNo)throws Exception;
		
		//공지사항 댓글등록
		int registComment(CommentDTO comment) throws Exception;
		
		//공지사항 댓글수정
		int modifyComment(CommentDTO comment) throws Exception;
		
		//공지사항 댓글삭제
		int deleteComment(int cmtNo) throws Exception;




		
 
	



		
	


	
	
}
 