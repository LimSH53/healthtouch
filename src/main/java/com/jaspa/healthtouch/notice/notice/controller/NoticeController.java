package com.jaspa.healthtouch.notice.notice.controller;



import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.dao.DataAccessException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jaspa.healthtouch.notice.notice.model.dto.NoticeDTO;
import com.jaspa.healthtouch.notice.notice.model.service.NoticeService;


@Controller
@RequestMapping("/notice")
public class NoticeController {
	private NoticeService noticeService;

	
	
	@Autowired
	public NoticeController(NoticeService noticeService, MessageSource messageSource) {
		this.noticeService= noticeService;
	}
	
	
	//공지사항 조회 
	@GetMapping("/notice")
	 public String noticeList(Model model, @ModelAttribute("params") NoticeDTO params)throws Exception {
			List<NoticeDTO> noticeList = noticeService.noticeList(params);

			model.addAttribute("noticeList", noticeList);
			
			return "/notice/notice";
		}

	
	//공지사항 상세조회 
	@GetMapping("/noticedetail")
	public String selectNoticeDetail (@ModelAttribute("params") NoticeDTO params, @RequestParam("noticeNo") int noticeNo, Model model) throws Exception {
		NoticeDTO notice = noticeService.selectNoticeDetail(noticeNo);
		model.addAttribute("notice", notice);
	
			return "/notice/noticedetail";	
		}
	
	 
	
	
	//공지사항 등록페이지 연결 
	@GetMapping("/noticeregist")
	public String noticeRegist(@ModelAttribute NoticeDTO notice) {
		return "notice/noticeregist";
			}
	
	
	//공지사항 등록
	@PostMapping("/noticeregist")
	public String registNotice(@ModelAttribute NoticeDTO notice,HttpServletRequest request ) throws Exception { 
			noticeService.registNotice(notice);
			
			
			return "redirect:/notice/notice"; 
		}
	
	//공지사항 수정 페이지 연결
	@GetMapping("/noticemodify")
	public String noticeModify(@RequestParam int noticeNo, Model model)throws Exception  {
		//상세조회에 담겨있는 값을 꺼냄
		NoticeDTO notice = noticeService.selectNoticeDetail(noticeNo);
		model.addAttribute("notice", notice); //key값 설정
			 
			return "/notice/noticemodify";
		}
		
	//공지사항 수정
	@PostMapping("/noticemodify") 
	public String modifyNotice(@ModelAttribute NoticeDTO notice) throws Exception {
		noticeService.modifyNotice(notice);
		
		//주소창에 해당 글의 번호를 파라미터로 보냄
		return "redirect:/notice/noticedetail?noticeNo=" + notice.getNoticeNo();
		
		}

	//공지사항 삭제
	@GetMapping("/delete")
	public String deleteNotice (@RequestParam(value ="noticeNo", required = false) int noticeNo) {
		  System.out.println("/delete 접근. noticeNo = " + noticeNo);
		  // 올바르지 않은 접근을 할 경우
		  if (noticeNo == 0) {
		  	// 올바르지 않은 접근이라는 메시지를 전달하고, 게시글 리스트로 리다이렉트 한다
		  	return "redirect:/notice/notice";
		  }

		  try {
		    boolean isDeleted = noticeService.deleteNotice(noticeNo);
		    
		    // false면 이미 게시글이 삭제된 상태
		    if (isDeleted == false) {
		    	// 게시글 삭제에 실패하였다는 메시지를 전달
		    }
		  } catch (DataAccessException e) {
		  	// 데이터베이스 처리 과정에 문제가 발생하였다는 메시지를 전달

		  } catch (Exception e) {
		  	// 시스템에 문제가 발생했다는 메시지를 전달
		  }

		  return "redirect:/notice/notice";
		}	
	
		
}
		
	
		
