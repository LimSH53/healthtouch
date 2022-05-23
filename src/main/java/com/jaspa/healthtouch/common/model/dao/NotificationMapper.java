package com.jaspa.healthtouch.common.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.jaspa.healthtouch.common.model.dto.NotificationDTO;

@Mapper
public interface NotificationMapper {

	void alert(NotificationDTO notification);

	List<NotificationDTO> findAllAlert(String id);

	void changeStatus(String no);

}
