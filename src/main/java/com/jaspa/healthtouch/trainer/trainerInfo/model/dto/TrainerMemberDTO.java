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


	private int trNum;
	private String name;
	private String contact;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date birthday;
	private String address;
	
	/* 트레이너 추가기입정보 */
	private int career;
	
	private MemberDTO member;
	
}
