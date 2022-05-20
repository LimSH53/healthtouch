package com.jaspa.healthtouch.member.locker.model.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.jaspa.healthtouch.login.model.dto.MemberDTO;
import com.jaspa.healthtouch.member.product.model.dto.OrderDTO;

import lombok.Data;

@Data
public class LockerDTO {

	
	private int locMngNum; 		//라커 관리번호
	private int locNum;			//라커 케이스 번호
	private String locStatus;	//라커 이용상태
	
	private int no;				//라커 구매번호
	private String id; 			//아이디
	private String name;		//이용 회원명
	
	@DateTimeFormat(pattern="yyyy-MM-dd")   //포맷필요
	private Date endDate; 	//라커 만료일
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date startDate;

	
	private MemberDTO member;
	private OrderDTO order;
}
