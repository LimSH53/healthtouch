package com.jaspa.healthtouch.notice.qna.model.dto;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.jaspa.healthtouch.common.model.dto.CommonDTO;
import com.jaspa.healthtouch.login.model.dto.MemberDTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter; 


@Getter
@Setter
@Data
public class QuestionDTO extends CommonDTO {
	private int qNo;
	private String memberId;
	private int categoryNo;
	private String qTitle;
	private String qContent;
	private String qDelete;
	@DateTimeFormat(pattern="yyyy-MM-dd") 
	private Date qDate;
	private Date qEditDate;
	private int  aRead; 
	
	private MemberDTO member;
	private MemberDTO trainer;
	
	private QuestionCategoryDTO questionCategory; 
	private List<AnswerDTO> answer;
	
}
