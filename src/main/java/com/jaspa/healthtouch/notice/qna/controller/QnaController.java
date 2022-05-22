package com.jaspa.healthtouch.notice.qna.controller;


import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jaspa.healthtouch.login.model.dto.UserImpl;
import com.jaspa.healthtouch.notice.notice.model.dto.CommentDTO;
import com.jaspa.healthtouch.notice.qna.model.dto.AnswerDTO;
import com.jaspa.healthtouch.notice.qna.model.dto.QuestionCategoryDTO;
import com.jaspa.healthtouch.notice.qna.model.dto.QuestionDTO;
import com.jaspa.healthtouch.notice.qna.model.service.QnaService;

import lombok.extern.slf4j.Slf4j;
  
@Slf4j
@Controller
@RequestMapping("/notice/*") 
public class QnaController {
	private QnaService qnaService;
	

	
	@Autowired
	public QnaController(QnaService qnaService,MessageSource messageSource) {
		this.qnaService= qnaService;
	}
	
	 
	//문의글 조회
	@GetMapping("/qna")
	public String qnaList(@ModelAttribute("params")QuestionDTO params,Model model)throws Exception {
		List<QuestionDTO> qnaList = qnaService.qnaList(params);
		
		model.addAttribute("qnaList", qnaList);
		
		log.info(qnaList.toString());
		
		return "notice/qna";
	}
	
	//문의글 상세조회
	@GetMapping("/qnadetail")
	public String selectQnaDetail(Model model,@RequestParam("qNo") int qNo)throws Exception {
		QuestionDTO qna = qnaService.selectQnaDetail(qNo);
		
		List<AnswerDTO> answerList = qnaService.answerList(qNo);
		
		log.info("qna:{}",qna);
		log.info("answerList:{}",answerList);
		
		model.addAttribute("qna", qna);
		model.addAttribute("answerList", answerList);
		
		qnaService.readReply(qNo);
		
		
		return "notice/qnadetail";
	}
	
	
	//등록페이지 내 카테고리 조회
	@GetMapping(value="categoryNo", produces="application/json; charset=UTF-8")
	@ResponseBody
	public List<QuestionCategoryDTO> findCategory(){
		return qnaService.findCategory();
	}

	//문의글 등록 페이지 연결
	@GetMapping("/qnaregist")
	public void qnaRegist() {		
	}
	  
	//문의글 등록
	@PostMapping("/qnaregist")
	public String registQna(@ModelAttribute QuestionDTO qna,@AuthenticationPrincipal UserImpl user) throws Exception {		
		
		qna.setMemberId(user.getId());
		qnaService.registQna(qna);
		
		
		return "redirect:/notice/qna";
	}
	  
	//문의글 수정 페이지 연결
	@GetMapping("/qnamodify")
	public String qnaModify(@RequestParam int qNo, Model model)throws Exception  {	
		QuestionDTO qna = qnaService.selectQnaDetail(qNo);
		model.addAttribute("qna",qna);
		
		return "notice/qnamodify";
	}
	
	//문의글 수정
	@PostMapping("/qnamodify")
	public String modifyQna(@ModelAttribute QuestionDTO qna,@AuthenticationPrincipal UserImpl user )throws Exception {	
		
		log.info(qna.toString());
		qna.setMemberId(user.getId());
		qnaService.modifyQna(qna);
		
		return "redirect:/notice/qnadetail?qNo=" + qna.getQNo();
	}
	
	//문의글 삭제
	@GetMapping("/qnadelete")
	public String deleteQna(QuestionDTO qna)throws Exception {	
		qnaService.deleteQna(qna.getQNo());
		
		return "redirect:/notice/qna";
	}
	
	
	//답변등록
	@RequestMapping("/replyRegist") 
	public String registReply(@ModelAttribute AnswerDTO answer, @AuthenticationPrincipal UserImpl user)throws Exception{
		 answer.setMemberId(user.getId());
		 log.info(answer.toString());
		 qnaService.registReply(answer);
		 return "redirect:/notice/qnadetail?qNo="+answer.getQNo();
	 }
		  

	//답변수정 
	   @RequestMapping("/replyModify")
	   @ResponseBody
	   public int modifyReply(@RequestBody Map<String, Object> modifyClassInfoMap)throws Exception{
	          
		   	  log.info("modifyReply:"+modifyClassInfoMap.toString());
	         
	          AnswerDTO answer = new AnswerDTO();
	          int aNo = (int) modifyClassInfoMap.get("aNo");
	          String aContent = (String) modifyClassInfoMap.get("aContent");
	         
	          log.info("no : " + aNo + ", content : " + aContent);   
	          
	          answer.setANo(aNo);
	          answer.setAContent(aContent);                
	          return qnaService.modifyReply(answer);
	       } 
	         
			
	
	//답글삭제
	@GetMapping("/replyDelete")
	private String deleteReply(@RequestParam("aNo") int aNo,@RequestParam("qNo") int qNo) throws Exception{
		qnaService.deleteReply(aNo);
		log.info("aNo:{}",aNo);
		return "redirect:/notice/qnadetail?qNo="+qNo;
		    }
		    

	
	
}