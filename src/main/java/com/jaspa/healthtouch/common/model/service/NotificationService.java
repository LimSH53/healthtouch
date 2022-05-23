package com.jaspa.healthtouch.common.model.service;

import java.util.List;

import com.jaspa.healthtouch.common.model.dto.NotificationDTO;

public interface NotificationService {

	void alert(NotificationDTO notification);

	List<NotificationDTO> findAllAlert(String id);

	void changeStatus(String no);

}
