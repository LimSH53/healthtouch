package com.jaspa.healthtouch.notice.notice.model.dao;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;


import com.jaspa.healthtouch.notice.notice.model.dto.NoticeDTO;

@Mapper
public interface NoticeMapper {
	
	
	//공지사항 조회
	List<NoticeDTO> noticeList()throws Exception;
	
	

	//공지사항 등록 
	void registNotice(NoticeDTO notice) throws Exception;

	
	NoticeDTO selectNoticeDetail(int noticeNo)throws Exception;

	void viewCount(int noticeNo)throws Exception;

	
	
}
 