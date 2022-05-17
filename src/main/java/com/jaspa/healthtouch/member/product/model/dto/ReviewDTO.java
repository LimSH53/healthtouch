package com.jaspa.healthtouch.member.product.model.dto;

import lombok.Data;

@Data
public class ReviewDTO {
	
	private int revNo;	// 리뷰 번호
	private int ordNo;	// 구매 번호
	private String contents;	// 리뷰 내용
	private String status;	//리뷰 등록 상태
	private int grade;	// 트레이너 평점
	
	private OrderDTO order;	//구매 정보

}
