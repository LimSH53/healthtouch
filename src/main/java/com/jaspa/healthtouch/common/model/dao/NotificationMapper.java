package com.jaspa.healthtouch.common.model.dao;

import org.apache.ibatis.annotations.Mapper;

import com.jaspa.healthtouch.common.model.dto.NotificationDTO;

@Mapper
public interface NotificationMapper {

	void modifyMemberTypeAlert(NotificationDTO notification);

}
