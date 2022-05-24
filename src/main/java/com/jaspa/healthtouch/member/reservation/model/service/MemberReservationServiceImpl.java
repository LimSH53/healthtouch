package com.jaspa.healthtouch.member.reservation.model.service;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaspa.healthtouch.center.trainer.model.dto.HolidayDTO;
import com.jaspa.healthtouch.common.paging.PaginationInfo;
import com.jaspa.healthtouch.member.reservation.model.dao.MemberReservationMapper;
import com.jaspa.healthtouch.member.reservation.model.dto.ReservationChangeDTO;
import com.jaspa.healthtouch.member.reservation.model.dto.ReservationDTO;
import com.jaspa.healthtouch.trainer.schedule.model.dto.TrainerScheduleDTO;

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
		System.out.println("총 개수 : " + reservationTotalCount);
		
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

	@Override
	public String findTrnId(String id) {
		return memberReservationMapper.findTrnId(id);
	}

	@Override
	public List<TrainerScheduleDTO> findScheduleById(String trnId) {
		return memberReservationMapper.findScheduleById(trnId);
	}

	@Override
	public List<HolidayDTO> findHolidyById(String trnId) {
		return memberReservationMapper.findHolidyById(trnId);
	}

	@Override
	public List<ReservationDTO> findReservationByTrnId(String trnId) {
		return memberReservationMapper.findReservationByTrnId(trnId);
	}

	@Override
	public void insertReservation(String memberId, String trnId, Date datetime) {
		memberReservationMapper.insertReservation(memberId, trnId, datetime);
	}

	@Override
	public void insertReservationChange(String memberId, String reservationNo, Date datetime) {
		memberReservationMapper.insertReservationChange(memberId, reservationNo, datetime);
	}

}
