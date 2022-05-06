package com.jaspa.healthtouch.notice.notice.model.service;



import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.jaspa.healthtouch.notice.notice.model.dto.NoticeDTO;


public interface NoticeService {
		

		void registNotice(NoticeDTO notice, MultipartHttpServletRequest multipartHttpServletRequest) throws Exception;
	
}
