package com.jaspa.healthtouch.trainer.schedule.model.dto;

import com.jaspa.healthtouch.login.model.dto.MemberDTO;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class TrainerScheduleDTO {

	
	private int no; 		// 스케줄 번호
	private String id; 			// 트레이너 아이디
	private String title; 	// 트레이너 이름
	
	private int fromTimeHour; 		// 시작 시간
	private int fromTimeHalf; 		// 시작 분
	private int toTimeHour; 		// 종료 시간
	private int toTimeHalf; 		// 종료 분
	
	private int weekDay; 	// 스케줄 요일
	private String color; 	// 스케줄 색상
	
	private MemberDTO member;
	
}
