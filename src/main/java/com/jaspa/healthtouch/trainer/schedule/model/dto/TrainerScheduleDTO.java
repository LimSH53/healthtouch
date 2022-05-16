package com.jaspa.healthtouch.trainer.schedule.model.dto;

import com.jaspa.healthtouch.login.model.dto.MemberDTO;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class TrainerScheduleDTO {

	
	private int schNum; 		// 스케줄 번호
	private String id; 			// 트레이너 아이디
	private String schName; 	// 트레이너 이름
	private String schWeek; 	// 스케줄 요일
	private int schStart; 		// 시작시간
	private int schEnd; 		// 종료시간
	private String schColor; 	// 스케줄 색상
	
	private MemberDTO member;
	
}
