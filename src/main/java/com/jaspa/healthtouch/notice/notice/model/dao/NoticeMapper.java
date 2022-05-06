package com.jaspa.healthtouch.notice.notice.model.dao;


import org.apache.ibatis.annotations.Mapper;


import com.jaspa.healthtouch.notice.notice.model.dto.NoticeDTO;

@Mapper
public interface NoticeMapper {
	
	void registNotice(NoticeDTO notice) throws Exception;
	

	
	
}
 