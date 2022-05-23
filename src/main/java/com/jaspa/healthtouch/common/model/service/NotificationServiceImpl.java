package com.jaspa.healthtouch.common.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaspa.healthtouch.common.model.dao.NotificationMapper;
import com.jaspa.healthtouch.common.model.dto.NotificationDTO;

@Service("notificationService")
public class NotificationServiceImpl implements NotificationService {
	private final NotificationMapper notificationMapper;
	
	@Autowired
	public NotificationServiceImpl(NotificationMapper notificationMapper) {
		this.notificationMapper = notificationMapper;
	}

	@Override
	public void alert(NotificationDTO notification) {
		notificationMapper.alert(notification);
	}

	@Override
	public List<NotificationDTO> findAllAlert(String id) {
		return notificationMapper.findAllAlert(id);
	}

	@Override
	public void changeStatus(String no) {
		notificationMapper.changeStatus(no);
	}

}
