package com.jaspa.healthtouch.trainer.reservation.model.dao;

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

}
