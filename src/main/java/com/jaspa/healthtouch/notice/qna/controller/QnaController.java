package com.jaspa.healthtouch.notice.qna.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jaspa.healthtouch.notice.qna.constant.Method;
import com.jaspa.healthtouch.notice.qna.model.dto.QuestionDTO;
import com.jaspa.healthtouch.notice.qna.model.service.QuestionService;
import com.jaspa.healthtouch.paging.Criteria;
import com.jaspa.healthtouch.notice.qna.util.UiUtils;


@Controller
@RequestMapping("/qna/*")
public class QnaController {

	@Autowired
	private QuestionService questionService;

	
	@GetMapping("/qna")
	public String questionList(@ModelAttribute("criteria") Criteria criteria, Model model) throws Exception {
		List<QuestionDTO> questionList = questionService.questionList(criteria);
		model.addAttribute("questionList", questionList);

		return "qna/qna";
	}
	
	
	@GetMapping("/qnadetail")
	public String questionDetail(@ModelAttribute("params") QuestionDTO params, @RequestParam(value = "qNo", required = false) String qNo, Model model) throws Exception{
		
		if (qNo == null) {
			return "redirect:/qna/qna";
		}

		QuestionDTO question = questionService.qnaDetail(qNo);
		if (question == null || "Y".equals(question.getQDelete())) {
			return  "redirect:/qna/qna";
		}
		model.addAttribute("question", question);
		return "qna/qnadetail";
	}
	
	@GetMapping("/qnaregist")
	public String qnaRegist(final QuestionDTO params, Model model ) {		
		
		try {
			boolean isRegistered = questionService.registQuestion(params);
			if (isRegistered == false) {
				return showMessageWithRedirect("게시글 등록에 실패하였습니다.", "/qna/qna", Method.GET, null, model);
			}
		} catch (DataAccessException e) {
			return showMessageWithRedirect("데이터베이스 처리 과정에 문제가 발생하였습니다.", "/qna/qna", Method.GET, null, model);

		} catch (Exception e) {
			return showMessageWithRedirect("시스템에 문제가 발생하였습니다.", "/qna/qna", Method.GET, null, model);
		}

		return showMessageWithRedirect("게시글 등록이 완료되었습니다.", "/qna/qna", Method.GET, null, model);
	}
		
	
	
	
	@GetMapping("/qnamodify")
	public String qnaModify() {		
		
		return "notice/qnamodify";
	}
	
	
}