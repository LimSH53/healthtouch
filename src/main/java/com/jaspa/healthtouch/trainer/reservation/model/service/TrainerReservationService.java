package com.jaspa.healthtouch.trainer.reservation.model.service;

import java.util.List;

import com.jaspa.healthtouch.member.reservation.model.dto.ReservationChangeDTO;
import com.jaspa.healthtouch.member.reservation.model.dto.ReservationDTO;

public interface TrainerReservationService {

	List<ReservationDTO> findAllReservation(ReservationDTO params);

	List<ReservationDTO> findReservationById(String id);

	ReservationChangeDTO getChangeDetail(int no);

	ReservationDTO getDetail(int no);

	void cancelReservation(String reservationNo);

}
