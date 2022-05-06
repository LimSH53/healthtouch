package com.jaspa.healthtouch.notice.notice.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.jaspa.healthtouch.notice.notice.model.dto.NoticeDTO;
import com.jaspa.healthtouch.notice.notice.model.service.NoticeService;



@Controller
@RequestMapping("/notice/*")
public class NoticeController {
	private NoticeService noticeService;
	
	@Value("${/Users/cota/spring/file/") 
	private String fileDownloadDirectory;
	
	
	@Autowired
	public NoticeController(NoticeService noticeService) {
		this.noticeService= noticeService;
	
	}
	
	
	@GetMapping("/notice")
	public String notice() throws Exception{
		
		return "notice/notice";
	}
	
	@GetMapping("/noticedetail")
	public String noticeDetail() {
		
		return "notice/noticedetail";
	}
		
	
	@GetMapping("/noticenone")
	public String noticeNone() {
		
		return "notice/noticenone";
	}
	
	
	@GetMapping("/noticemodify")
	public String noticeModify() {
		
		return "notice/noticemodify";
	}
	
	
	//공지사항 등록 페이지 연결
	@GetMapping("/noticeregist")
	public String noticeRegist() {
		
		return "notice/noticeregist";
	}
	
	// multipartHttpServletRequest 사용해 인터페이스에 업로드된 파일을 처리
	@GetMapping("/registnotice")
		public String registNotice(NoticeDTO notice,MultipartHttpServletRequest multipartHttpServletRequest) throws Exception {
			noticeService.registNotice(notice, multipartHttpServletRequest);
			
			return "redirect:/notice/notice";
		
}
		
		
	
}
		
