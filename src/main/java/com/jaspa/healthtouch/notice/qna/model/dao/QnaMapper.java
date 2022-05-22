package com.jaspa.healthtouch.notice.qna.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.jaspa.healthtouch.notice.qna.model.dto.AnswerDTO;
import com.jaspa.healthtouch.notice.qna.model.dto.QuestionCategoryDTO;
import com.jaspa.healthtouch.notice.qna.model.dto.QuestionDTO;


@Mapper
public interface QnaMapper {

	
	//문의글 조회
	List<QuestionDTO> qnaList(QuestionDTO params)throws Exception;
	
	 
	//문의글 페이지 조회
	int qnaFind(QuestionDTO params)throws Exception;
	
	//문의글 상세 조회
	QuestionDTO selectQnaDetail(int qNo)throws Exception;
	
	//등록페이지 내 카테고리 조회
	List<QuestionCategoryDTO> findCategory();
	
	//답변여부 표시
	void readReply(int qNo) throws Exception;
	 
	//문의글 등록
	int registQna(QuestionDTO q)throws Exception;

	//문의글 수정
	void modifyQna(QuestionDTO qna)throws Exception;

	//문의글 삭제
	void deleteQna(int qNo)throws Exception;
	
	//공지사항 댓글목록
	int answerCount() throws Exception;

	//답글목록조회
	List<AnswerDTO> answerList(int qNo) throws Exception;

	//답변등록
	int registReply(AnswerDTO answer)throws Exception;

	//답변수정 
	int modifyReply(AnswerDTO answer)throws Exception;

	//답글삭제
	int deleteReply(int aNo)throws Exception;



	


}
