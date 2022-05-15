package com.jaspa.healthtouch.member.reservation.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.jaspa.healthtouch.member.reservation.model.dto.ReservationChangeDTO;
import com.jaspa.healthtouch.member.reservation.model.dto.ReservationDTO;

@Mapper
public interface MemberReservationMapper {

	int findAllReservationTotalCount(ReservationDTO params);

	List<ReservationDTO> findAllReservation(ReservationDTO params);

	ReservationDTO getDetail(int no);

	ReservationChangeDTO getChangeDetail(int no);

	void cancelReservation(String reservationNo);

	void cancelReservationChange(String reservationChangeNo);

	List<ReservationDTO> findReservationById(String id);

}
