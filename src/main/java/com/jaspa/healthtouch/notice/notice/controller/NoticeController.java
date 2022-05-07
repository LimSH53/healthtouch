package com.jaspa.healthtouch.notice.notice.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	//공지사항 조회 
	@RequestMapping("/notice")
	 public ModelAndView  noticeList() throws Exception{
		 ModelAndView mv = new ModelAndView("/notice/notice");
		
		List<NoticeDTO> noticeList = noticeService.noticeList();
		 
		 mv.addObject("noticeList", noticeList);
		return mv;
	}
	
	//공지사항 상세조회 
	@RequestMapping("/noticedetail/{noticeNo}")
	public ModelAndView selectBoardDetail (@PathVariable("noticeNo") @RequestParam int noticeNo) throws Exception {
		ModelAndView mv = new ModelAndView("/notice/noticedetail");
		
		NoticeDTO notice = noticeService.selectNoticeDetail(noticeNo);
		mv.addObject("notice", notice);
		
		return mv;
		
	}
	
	
	//공지사항 등록 페이지 연결
	@GetMapping("/noticeregist")
	public String noticeRegist() {
		
		return "notice/noticeregist";
	}
	
	//공지사항 등록
	@RequestMapping("/registnotice")
		public String registNotice(@ModelAttribute NoticeDTO notice) throws Exception {
			noticeService.registNotice(notice);
			
			//객제 재사용
			return "forward:/notice/notice";  
			
	}
	
	//공지사항 수정 페이지 연결
	@RequestMapping("/noticemodify/{noticeNo}")
	public String noticeModify(@PathVariable("noticeNo") int noticeNo, Model model)throws Exception  {
		model.addAttribute("detail", noticeService.selectNoticeDetail(noticeNo));
		
		return "notice/noticemodify";
	}
	
	//공지사항 수정
	@GetMapping("/modifyNotice")
	public String modifyNotice(@ModelAttribute NoticeDTO notice) throws Exception {
		noticeService.modifyNotice(notice);
		int notNo = notice.getNoticeNo();
		String noticeNo =Integer.toString(notNo);
		
		return "redirect:/notice/noticedetail/"+noticeNo;
	}

	//공지사항 삭제
	@RequestMapping("/delete/{noticeNo}")
	public String deleteNotice (@PathVariable("noticeNo") int noticeNo) throws Exception {
		
		noticeService.deleteNotice(noticeNo);
		return "redirect:/notice/notice";
		
	}
		
		
}
		
	
		
