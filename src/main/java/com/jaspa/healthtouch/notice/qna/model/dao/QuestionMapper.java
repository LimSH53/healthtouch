package com.jaspa.healthtouch.notice.qna.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.jaspa.healthtouch.notice.qna.model.dto.QuestionDTO;
import com.jaspa.healthtouch.paging.Criteria;


@Mapper
public interface QuestionMapper {
	
	//문의 조회
	List<QuestionDTO> questionList(Criteria criteria);


	//문의 페이지 조회
	int listQuestionCount(Criteria criteria);
	
	//문의 상세조회
	QuestionDTO questionDetail(String qNo);
	
	//문의 등록
	int registQuestion(QuestionDTO params);

	//문의 수정
	int updateQuestion(QuestionDTO params);

	//문의삭제
	int deleteQuestion (String qNo);



}
