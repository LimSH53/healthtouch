package com.jaspa.healthtouch.trainer.reservation.model.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaspa.healthtouch.common.paging.PaginationInfo;
import com.jaspa.healthtouch.member.reservation.model.dto.ReservationChangeDTO;
import com.jaspa.healthtouch.member.reservation.model.dto.ReservationDTO;
import com.jaspa.healthtouch.trainer.reservation.model.dao.TrainerReservationMapper;

@Service("trainerReservationService")
public class TrainerReservationServiceImpl implements TrainerReservationService {
	private final TrainerReservationMapper trainerReservationMapper;
	
	@Autowired
	public TrainerReservationServiceImpl(TrainerReservationMapper trainerReservationMapper) {
		this.trainerReservationMapper = trainerReservationMapper;
	}

	@Override
	public List<ReservationDTO> findAllReservation(ReservationDTO params) {
		List<ReservationDTO> reservationList = Collections.emptyList();
		
		int reservationTotalCount = trainerReservationMapper.findAllReservationTotalCount(params);
		
		PaginationInfo paginationInfo = new PaginationInfo(params);
		paginationInfo.setTotalRecordCount(reservationTotalCount);
		
		params.setPaginationInfo(paginationInfo);
		
		if(reservationTotalCount > 0) {
			reservationList = trainerReservationMapper.findAllReservation(params);
		}
		
		return reservationList;
	}

	@Override
	public List<ReservationDTO> findReservationById(String id) {
		return trainerReservationMapper.findReservationById(id);
	}

	@Override
	public ReservationChangeDTO getChangeDetail(int no) {
		return trainerReservationMapper.getChangeDetail(no);
	}

	@Override
	public ReservationDTO getDetail(int no) {
		return trainerReservationMapper.getDetail(no);
	}

	@Override
	public void cancelReservation(String reservationNo) {
		trainerReservationMapper.cancelReservation(reservationNo);
	}

}
