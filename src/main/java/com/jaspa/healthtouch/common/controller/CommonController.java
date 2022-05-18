package com.jaspa.healthtouch.common.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jaspa.healthtouch.common.model.dto.NotificationDTO;
import com.jaspa.healthtouch.common.model.service.NotificationService;

@Controller
@RequestMapping("/common")
public class CommonController {
	private NotificationService notificationService;
	
	@Autowired
	public CommonController(NotificationService notificationService) {
		this.notificationService = notificationService;
	}
	
	@GetMapping("/denied")
	public void deniedPage() {}
	
	@PostMapping("/modifyMemberTypeAlert")
	@ResponseBody
	public void modifyMemberTypeAlert(@RequestBody Map<String, Object> alertMap) {
		NotificationDTO notification = new NotificationDTO();
		notification.setTitle((String)alertMap.get("title"));
		notification.setContent((String)alertMap.get("content"));
		notification.setReqUrl((String)alertMap.get("reqUrl"));
		notification.setMemberId((String)alertMap.get("memberId"));
		
		notificationService.modifyMemberTypeAlert(notification);
	}
}
