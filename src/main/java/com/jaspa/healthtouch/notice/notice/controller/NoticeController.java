package com.jaspa.healthtouch.notice.notice.controller;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	public String selectBoardDetail (@PathVariable("noticeNo") int noticeNo,Model model) throws Exception {
		model.addAttribute("notice", noticeService.selectNoticeDetail(noticeNo));
	
		if(noticeService.fileDetail(noticeNo)== null) {
			return "notice/detail";
		}else {
		model.addAttribute("file", noticeService.fileDetail(noticeNo));
			return "notice/detail";	
		}
	
		
	}
	
	
	//공지사항 등록 페이지 연결
	@GetMapping("/noticeregist")
	public String noticeRegist() {
		
		return "notice/noticeregist";
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
	
	
	//공지사항 파일 업로드
	@RequestMapping("/notice/fileDown/{noticeNo}")
	public void fileDown(@PathVariable("noticeNo") int noticeNo, HttpServletRequest request, HttpServletResponse response ) throws UnsupportedEncodingException, Exception { 
		
		request.setCharacterEncoding("UTF-8");
		AttachmentDTO attachmentDTO = noticeService.fileDetail(noticeNo);
		
		//파일 업로드할 경로 지정
		try {
			String fileUrl = attachmentDTO.getRoot();
			System.out.println(fileUrl);
			fileUrl += "/";
			String savePath = fileUrl;
			String fileName = attachmentDTO.getEditFile();
			
		//내보낼때 파일 경로 지정
			String originFileName = attachmentDTO.getFile();
			InputStream ins = null;
			OutputStream outs = null;
			File file = null;
			Boolean skip = false;
			String client = "";
			
		//파일 읽어서 스트림에 담기 
		try {
			file = new File(savePath, fileName);
			ins = new FileInputStream(file);
		}catch (FileNotFoundException fe) {
			skip = true;
		}
		
		client = request.getHeader("User-Agent");
		
		//파일 다운로드 헤더 지정
		response.reset();
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Description", "HTML Generated Data");
		
		if(!skip) {
		//IE
			if(client.indexOf("MSIE") != -1) {
			  response.setHeader("Content-Disposition", "attachment; filename=\"" +
			  java.net.URLEncoder.encode(originFileName,"UTF-8").replaceAll("\\+", "\\")+ "\"");
		//IE 11 이상
			}else if (client.indexOf("Trident") != -1) {
			  response.setHeader("Content-Disposition", "attachment; filename=\"" +
			  java.net.URLEncoder.encode(originFileName,"UTF-8").replaceAll("\\+", "\\")+ "\"");
		//한글 파일명 처리
			}else {
			  response.setHeader("Content-Disposition", "attachment; filename=\"" +
				new String(originFileName.getBytes("UTF-8"),"ISO8859_1")+ "\"");
			 response.setHeader("Content-Type", "application/octet-stream; charset=utf-8");
			}
		
		response.setHeader("Content-Length", "" + file.length());
		outs = response.getOutputStream();
		byte b[]= new byte[(int) file.length()];
		int leng = 0;
		
		while ((leng = ins.read(b)) >0) {
			outs.write(b,0, leng);
		   }
		}else{
			response.setContentType("text/html; charset-UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script> alert ('파일을 찾을 수 없습니다.'); history.back(); </script>");
			out.flush();			
		}
			ins.close();
			outs.close();
		
	}catch(Exception e) {
		System.out.println("ERROR : " + e.getStackTrace());
	}

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
		
	
		
