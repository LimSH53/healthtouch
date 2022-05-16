package com.jaspa.healthtouch.member.product.model.dto;

import lombok.Data;

@Data
public class ReviewDTO {
	
	int revNo;	// 리뷰 번호
	int ordNo;	// 구매 번호
	String contents;	// 리뷰 내용
	String status;	//리뷰 등록 상태
	int grade;	// 트레이너 평점
	
	OrderDTO order;	//구매 정보

}
