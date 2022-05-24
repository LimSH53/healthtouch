package com.jaspa.healthtouch.member.reservation.model.service;

import java.util.Date;
import java.util.List;

import com.jaspa.healthtouch.center.trainer.model.dto.HolidayDTO;
import com.jaspa.healthtouch.member.reservation.model.dto.ReservationChangeDTO;
import com.jaspa.healthtouch.member.reservation.model.dto.ReservationDTO;
import com.jaspa.healthtouch.trainer.schedule.model.dto.TrainerScheduleDTO;

public interface MemberReservationService {

	List<ReservationDTO> findAllReservation(ReservationDTO params);

	ReservationDTO getDetail(int no);

	ReservationChangeDTO getChangeDetail(int no);

	void cancelReservation(String reservationNo);

	void cancelReservationChange(String reservationChangeNo);

	List<ReservationDTO> findReservationById(String id);

	String findTrnId(String id);

	List<TrainerScheduleDTO> findScheduleById(String trnId);

	List<HolidayDTO> findHolidyById(String trnId);

	List<ReservationDTO> findReservationByTrnId(String trnId);

	void insertReservation(String memberId, String trnId, Date datetime);

	void insertReservationChange(String memberId, String reservationNo, Date datetime);
	
}
