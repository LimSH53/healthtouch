package com.jaspa.healthtouch.trainer.trainerInfo.model.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.jaspa.healthtouch.center.tr_management.model.dto.TrainerInfoDTO;
import com.jaspa.healthtouch.login.model.dto.MemberDTO;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class TrainerMemberDTO {

	private String id;
	private int trNum; 							// 트레이너 번호
	private String name;						// 트레이너 이름 (회원이름)
	private String contact;						// 연락처
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date birthday;						// 트레이너 생년월일		
	private String address;						// 주소
	
	/* 트레이너 추가기입정보 */
	private int career;							// 경력
	
	private MemberDTO member;
	
}
