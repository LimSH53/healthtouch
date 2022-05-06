package com.jaspa.healthtouch.notice.notice.model.service;




import java.util.List;

import com.jaspa.healthtouch.notice.notice.model.dto.NoticeDTO;


public interface NoticeService {
		

		void registNotice(NoticeDTO notice) throws Exception;

		List<NoticeDTO> noticeList() throws Exception ;

		NoticeDTO selectBoardDetail(int noticeNo) throws Exception ;



	
	
}
 