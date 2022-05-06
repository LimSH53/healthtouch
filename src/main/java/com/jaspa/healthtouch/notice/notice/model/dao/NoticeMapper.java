package com.jaspa.healthtouch.notice.notice.model.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;


import com.jaspa.healthtouch.notice.notice.model.dto.NoticeDTO;

@Mapper
public interface NoticeMapper {
	
	void registNotice(NoticeDTO notice) throws Exception;

	List<NoticeDTO> noticeList()throws Exception;

	NoticeDTO selectBoardDetail(int noticeNo);

	void viewCount(int noticeNo);

	int selectNoticeTotalCount();

	
	
}
 