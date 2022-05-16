package com.jaspa.healthtouch.member.product.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.jaspa.healthtouch.center.product.model.dto.ProductDTO;
import com.jaspa.healthtouch.login.model.dto.MemberDTO;
import com.jaspa.healthtouch.member.product.model.dto.OrderDTO;
import com.jaspa.healthtouch.member.product.model.dto.PaymentDTO;
import com.jaspa.healthtouch.member.product.model.dto.ReviewDTO;

@Mapper
public interface MemberProMapper {

	// 회원권 조회 회원용
	List<ProductDTO> findAllMembership();

	// 회원 구매 등록
	int insertOrder(OrderDTO order, int period);

	// 회원 결제 정보
	int insertPayment(PaymentDTO payment);

	// 회원 구매 목록
	List<PaymentDTO> selectOrderList(String userId);

	// 회원 구매 날짜별 조회
	List<PaymentDTO> searchOrderList(int searchOption, String userId);

	// 트레이너 리스트
	List<MemberDTO> findTrainerList();

	// 수강권 상품 조회
	List<ProductDTO> findAllPTList();

	// 락커 이용권 조회
	List<ProductDTO> findAllLocker();

	// 운동복 이용권 조회
	List<ProductDTO> findAllSportswear();

	// 리뷰 등록 관련 정보 조회
	OrderDTO selectReviewInfo(int ordNo, String userId);

	// 리뷰 등록
	int registReview(ReviewDTO review);

	// order 테이블 리뷰등록 여부 Y 변경
	int updateOrdStatus(int orderNo);

	// 마이리뷰 조회
	ReviewDTO selectMyreview(int no, String userId);





}
