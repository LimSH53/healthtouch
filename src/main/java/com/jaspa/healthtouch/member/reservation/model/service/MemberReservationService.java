package com.jaspa.healthtouch.member.reservation.model.service;

import java.util.List;

import com.jaspa.healthtouch.member.reservation.model.dto.ReservationChangeDTO;
import com.jaspa.healthtouch.member.reservation.model.dto.ReservationDTO;

public interface MemberReservationService {

	List<ReservationDTO> findAllReservation(ReservationDTO params);

	ReservationDTO getDetail(int no);

	ReservationChangeDTO getChangeDetail(int no);

	void cancelReservation(String reservationNo);

	void cancelReservationChange(String reservationChangeNo);

	List<ReservationDTO> findReservationById(String id);
	
}
