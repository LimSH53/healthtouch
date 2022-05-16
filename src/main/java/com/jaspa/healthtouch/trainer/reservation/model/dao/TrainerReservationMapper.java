package com.jaspa.healthtouch.trainer.reservation.model.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.jaspa.healthtouch.member.reservation.model.dto.ReservationChangeDTO;
import com.jaspa.healthtouch.member.reservation.model.dto.ReservationDTO;

@Mapper
public interface TrainerReservationMapper {

	int findAllReservationTotalCount(ReservationDTO params);

	List<ReservationDTO> findAllReservation(ReservationDTO params);

	List<ReservationDTO> findReservationById(String id);

	ReservationChangeDTO getChangeDetail(int no);

	ReservationDTO getDetail(int no);

	void cancelReservation(String reservationNo);

	void cancelAllReservation(String reservationNo);

	void acceptReservation(String reservationNo);

	void reservationChange(String reservationNo, Date datetime);

	void acceptReservationChange(String reservationChangeNo);

	Date findReservationChangeDatetime(String reservationChangeNo);

	String findIdByReservationNo(String reservationNo);

	void minusRemainCount(String memberId, int ordNo);

	int findOrdNoById(String memberId);

	void plusRemainCount(String memberId, int ordNo);

}
