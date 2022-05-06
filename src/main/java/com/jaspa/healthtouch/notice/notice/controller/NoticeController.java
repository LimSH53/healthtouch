package com.jaspa.healthtouch.notice.notice.controller;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

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
	public String noticeList(Model model) throws Exception{
		  List<NoticeDTO> noticeList = noticeService.noticeList();
		 
		 model.addAttribute("noticeList", noticeList);
		return "notice/notice";
	}
	
	 

	@GetMapping("/noticedetail")
	public String noticeDetail() {
		
		return "notice/noticedetail";
	}
		
	@RequestMapping("/noticedetail")
	public ModelAndView selectBoardDetail (@RequestParam int noticeNo) throws Exception {
		ModelAndView mv = new ModelAndView("/notice/noticedetail");
		
		NoticeDTO notice = noticeService.selectBoardDetail(noticeNo);
		mv.addObject("notice", notice);
		
		return mv;
		
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
		public String registNotice(@ModelAttribute NoticeDTO notice) throws Exception {
			noticeService.registNotice(notice);
			
			return "redirect:/notice/notice";
		
}
		
	
}
		
