package com.jaspa.healthtouch.notice.notice.model.service;




import java.util.List;

import com.jaspa.healthtouch.notice.notice.model.dto.NoticeDTO;


public interface NoticeService {
		
		//공지사항 조회
		List<NoticeDTO> noticeList() throws Exception ;

		
		//공지사항 등록
		void registNotice(NoticeDTO notice) throws Exception;


		NoticeDTO selectNoticeDetail(int noticeNo) throws Exception ;



	
	
}
 