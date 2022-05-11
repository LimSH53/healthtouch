package com.jaspa.healthtouch.member.product.model.dto;

import com.jaspa.healthtouch.center.product.model.dto.ProductDTO;
import com.jaspa.healthtouch.login.model.dto.MemberDTO;

import lombok.Data;

@Data
public class OrderDTO {
	
	private int no;
	private int proNo;
	private String memberId;
	private String  TrnId;
	private java.util.Date startDate;
	private int remainCount;
	private java.util.Date endDate;
	private java.util.Date modEndDate;
	private String modReason;
	
	private MemberDTO member;
	private ProductDTO product;
	

}
