package com.jaspa.healthtouch.member.product.model.dto;

import org.springframework.format.annotation.DateTimeFormat;

import com.jaspa.healthtouch.center.product.model.dto.ProductDTO;
import com.jaspa.healthtouch.login.model.dto.MemberDTO;

import lombok.Data;

@Data
public class OrderDTO {
	
	private int no;
	private int proNo;
	private String memberId;
	private String  trnId;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private java.util.Date startDate;
	private int remainCount;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private java.util.Date endDate;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private java.util.Date modEndDate;
	private String modReason;
	private String revStatus;
	
	// 회원정보
	private MemberDTO member;
	// 트레이너 정보
	private MemberDTO trainer;
	private ProductDTO product;
	

}
