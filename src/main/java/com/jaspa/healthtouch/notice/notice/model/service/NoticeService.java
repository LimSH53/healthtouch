package com.jaspa.healthtouch.notice.notice.model.service;




import java.util.List;


import com.jaspa.healthtouch.notice.notice.model.dto.AttachmentDTO;
import com.jaspa.healthtouch.notice.notice.model.dto.NoticeDTO;


public interface NoticeService {
		
		//공지사항 조회
		List<NoticeDTO> noticeList() throws Exception ;
		
		//공지사항 상세 
		NoticeDTO selectNoticeDetail(int noticeNo) throws Exception ;

		
		//공지사항 등록
		int registNotice(NoticeDTO notice) throws Exception;
	
		//공시사항 파일 등록(파일 업로드)
		int insertFile(AttachmentDTO file) throws Exception;
		
		//공시사항 파일 등록(파일 다운로드)
		AttachmentDTO fileDetail(int noticeNo)throws Exception;
		
		//공지사항 수정  
		int modifyNotice(NoticeDTO notice) throws Exception;
		
		//공지사항 삭제
		boolean deleteNotice(int noticeNo) throws Exception;
		
	


	
	
}
 