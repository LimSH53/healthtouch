package com.jaspa.healthtouch.member.product.model.dto;

import lombok.Data;

@Data
public class PaymentDTO {
	
	private int no;
	private int ordNo;
	private java.util.Date date;
	private String status;
	private int amount;
	
	private OrderDTO order;

}
