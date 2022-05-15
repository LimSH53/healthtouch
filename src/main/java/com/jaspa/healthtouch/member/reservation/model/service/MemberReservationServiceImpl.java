package com.jaspa.healthtouch.member.reservation.model.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaspa.healthtouch.common.paging.PaginationInfo;
import com.jaspa.healthtouch.member.reservation.model.dao.MemberReservationMapper;
import com.jaspa.healthtouch.member.reservation.model.dto.ReservationChangeDTO;
import com.jaspa.healthtouch.member.reservation.model.dto.ReservationDTO;

@Service("memberReservationService")
public class MemberReservationServiceImpl implements MemberReservationService {
	private final MemberReservationMapper memberReservationMapper;
	
	@Autowired
	public MemberReservationServiceImpl(MemberReservationMapper memberReservationMapper) {
		this.memberReservationMapper = memberReservationMapper;
	}

	@Override
	public List<ReservationDTO> findAllReservation(ReservationDTO params) {
		List<ReservationDTO> reservationList = Collections.emptyList();
		
		int reservationTotalCount = memberReservationMapper.findAllReservationTotalCount(params);
		
		PaginationInfo paginationInfo = new PaginationInfo(params);
		paginationInfo.setTotalRecordCount(reservationTotalCount);
		
		params.setPaginationInfo(paginationInfo);
		
		if(reservationTotalCount > 0) {
			reservationList = memberReservationMapper.findAllReservation(params);
		}
		
		return reservationList;
	}

	@Override
	public ReservationDTO getDetail(int no) {
		return memberReservationMapper.getDetail(no);
	}

	@Override
	public ReservationChangeDTO getChangeDetail(int no) {
		return memberReservationMapper.getChangeDetail(no);
	}

	@Override
	public void cancelReservation(String reservationNo) {
		memberReservationMapper.cancelReservation(reservationNo);
	}

	@Override
	public void cancelReservationChange(String reservationChangeNo) {
		memberReservationMapper.cancelReservationChange(reservationChangeNo);
	}

	@Override
	public List<ReservationDTO> findReservationById(String id) {
		return memberReservationMapper.findReservationById(id);
	}

}
