package com.jaspa.healthtouch.member.product.model.dto;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class PaymentDTO {
	
	private int no;
	private int ordNo;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private java.util.Date date;
	private String status;
	private int amount;
	
	private OrderDTO order;

}
