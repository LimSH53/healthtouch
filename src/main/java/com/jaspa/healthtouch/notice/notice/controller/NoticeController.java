package com.jaspa.healthtouch.notice.notice.controller;


import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.jaspa.healthtouch.notice.notice.model.dto.AttachmentDTO;
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
	
	//공지사항 파일 업로드
	@RequestMapping("/registnotice")
	public String insertFile(@ModelAttribute NoticeDTO notice, @RequestPart MultipartFile file, HttpServletRequest request ) throws IllegalStateException, IOException, Exception { 
		
		if(file.isEmpty()) {
			noticeService.registNotice(notice);
		}else {
			String fileName = file.getOriginalFilename();// 컴퓨터에 저장된 명칭
			
			//확장자
			String fileNameExtension = FilenameUtils.getExtension(fileName).toLowerCase();
			File destinationFile; //DB에 저장할 파일 명칭
			String destinationFileName;
			//절대경로 설정 (해당 부분에 경로 설정)
			String fileUrl = "/Users/cota/spring/file";
		// 우선 실행시 동작
			do {
			//저장할 파일명칭 생정
			destinationFileName = RandomStringUtils.randomAlphanumeric(32)+ "." + fileNameExtension;
			destinationFile = new File(fileUrl + destinationFileName); 
		}while (destinationFile.exists());
			
			destinationFile.getParentFile().mkdirs(); //디렉토리
			file.transferTo(destinationFile);
			
			noticeService.registNotice(notice);
			
			AttachmentDTO files = new AttachmentDTO();
			files.setNoticeNo(notice.getNoticeNo());
			files.setEditFile(destinationFileName);
			files.setFile(fileName);
			files.setRoot(fileUrl);
			
			noticeService.insertFile(files);
			
		}
			return "forward:/notice/notice"; //객체 재사용
			
			
			
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
		
	
		
