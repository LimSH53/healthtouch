package com.jaspa.healthtouch.notice.qna.model.service;


import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaspa.healthtouch.common.paging.PaginationInfo;
import com.jaspa.healthtouch.login.model.dto.MemberRoleDTO;
import com.jaspa.healthtouch.notice.notice.model.dao.NoticeMapper;
import com.jaspa.healthtouch.notice.notice.model.dto.CommentDTO;
import com.jaspa.healthtouch.notice.notice.model.dto.NoticeDTO;
import com.jaspa.healthtouch.notice.notice.model.service.NoticeServiceImpl;
import com.jaspa.healthtouch.notice.qna.model.dao.QnaMapper;
import com.jaspa.healthtouch.notice.qna.model.dto.AnswerDTO;
import com.jaspa.healthtouch.notice.qna.model.dto.QuestionCategoryDTO;
import com.jaspa.healthtouch.notice.qna.model.dto.QuestionDTO;

import lombok.extern.slf4j.Slf4j;
 

@Slf4j
@Service("QnaService") 
public class QnaServiceImpl implements QnaService {
	private final QnaMapper qnaMapper;
	
	@Autowired
	public QnaServiceImpl(QnaMapper qnaMapper) {
		this.qnaMapper = qnaMapper;
	} 
	 
	//문의글 조회
	@Override
	public List<QuestionDTO> qnaList(QuestionDTO params)throws Exception{
		  List<QuestionDTO> qnaList = Collections.emptyList();
		  
		  int qnaTotalCount = qnaMapper.qnaFind(params);
		  	PaginationInfo paginationInfo = new PaginationInfo(params);
			paginationInfo.setTotalRecordCount(qnaTotalCount);
			params.setPaginationInfo(paginationInfo);
			 
			log.info("firstRecordIndex : {}", params.getPaginationInfo().getFirstRecordIndex());
			log.info("recordsPerPage: {}", params.getRecordsPerPage());
			 
			if(qnaTotalCount > 0) {
				qnaList = qnaMapper.qnaList(params);
			}
			
			return qnaList;
		    }	  
	 
	//문의글 상세 조회
	@Override
	public QuestionDTO selectQnaDetail(int qNo) throws Exception {
		 return qnaMapper.selectQnaDetail(qNo);
		
	}
	 
	//등록페이지 내 카테고리 조회
	@Override
	public List<QuestionCategoryDTO> findCategory() {
		return qnaMapper.findCategory();
	}
	
	//답변여부 표시
	@Override
	public void readReply(int qNo) throws Exception {
		qnaMapper.readReply(qNo);
	}

	
	//문의글 등록
	@Override
	public boolean registQna(QuestionDTO qna)throws Exception  {
	    qnaMapper.readReply(qna.getQNo());
		
		int result = qnaMapper.registQna(qna);
		
		if(result <= 0) {
			throw new Exception("문의등록에 실패하였습니다.");
		}
		
		return result > 0 ? true : false;
	}

	//문의글 수정
	@Override
	public void modifyQna(QuestionDTO qna)throws Exception{
		qnaMapper.modifyQna(qna);
		

		}
	
	//문의글 삭제
	@Override
	public void deleteQna(int qNo)throws Exception{
		qnaMapper.deleteQna(qNo);
		

		}

	//답글목록조회
	@Override
	public List<AnswerDTO>answerList(int qNo) throws Exception{
		return qnaMapper.answerList(qNo);

	}
	
	//답변등록
	@Override
	public int registReply(AnswerDTO answer) throws Exception{
		return qnaMapper.registReply(answer);
	}
	
	//답변수정 
	@Override
	public int modifyReply(AnswerDTO answer) throws Exception{
		log.info("넘어가라:",answer);
		return qnaMapper.modifyReply(answer);
	}
	
	//답글삭제
	@Override
	public int deleteReply(int aNo) throws Exception{
		return qnaMapper.deleteReply(aNo);
	}


	
	}

