package com.jaspa.healthtouch.member.reservation.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jaspa.healthtouch.center.trainer.model.dto.HolidayDTO;
import com.jaspa.healthtouch.common.model.dto.FullCalendarDTO;
import com.jaspa.healthtouch.common.model.dto.HolidayTimegridDTO;
import com.jaspa.healthtouch.common.model.dto.ReservationTimegridDTO;
import com.jaspa.healthtouch.common.model.dto.ScheduleTimegridDTO;
import com.jaspa.healthtouch.login.model.dto.UserImpl;
import com.jaspa.healthtouch.member.reservation.model.dto.ReservationChangeDTO;
import com.jaspa.healthtouch.member.reservation.model.dto.ReservationDTO;
import com.jaspa.healthtouch.member.reservation.model.service.MemberReservationService;
import com.jaspa.healthtouch.trainer.schedule.model.dto.TrainerScheduleDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/member/reservation")
public class MemberReservationController {
	private MemberReservationService memberReservationService;
	
	@Autowired
	public MemberReservationController(MemberReservationService memberReservationService) {
		this.memberReservationService = memberReservationService;
	}
	
	@GetMapping("/calendar")
	public void calendar() {}
	
	@SuppressWarnings("deprecation")
	@PostMapping("/calendar")
	@ResponseBody
	public Map<String, FullCalendarDTO> calendar(@AuthenticationPrincipal UserImpl user) throws JsonProcessingException {
		Map<String, FullCalendarDTO> rsvMap = new HashMap<>();
		List<ReservationDTO> reservationList = memberReservationService.findReservationById(user.getId());
		
		for(int i = 0; i < reservationList.size(); i++) {
			ReservationDTO reservation = reservationList.get(i);
			String title = "PT";
			Date start = reservation.getDatetime();
			
			rsvMap.put("event" + i, new FullCalendarDTO(title, start, false));
		}
		
		return rsvMap;
	}
	
	@GetMapping("/reservationList")
	public String reservationList(@ModelAttribute("params") ReservationDTO params, Model model, @AuthenticationPrincipal UserImpl user) {
		params.setMemberId(user.getId());
		List<ReservationDTO> reservationList = memberReservationService.findAllReservation(params);
		
		System.out.println(reservationList);
		
		model.addAttribute("reservationList", reservationList);
		
		return "member/reservation/reservationList";
	}
	
	@PostMapping("/detail")
	@ResponseBody
	public Object getDetail(@RequestParam("reservationNo") int no) {
		ReservationChangeDTO reservationChange = memberReservationService.getChangeDetail(no);
		
		if(reservationChange != null) {
			return reservationChange;
		} else {
			return memberReservationService.getDetail(no);
		}
	}
	
	@PostMapping("/cancel")
	@ResponseBody
	public void cancelReservation(@RequestParam("reservationNo") String reservationNo) {
		memberReservationService.cancelReservation(reservationNo);
	}
	
	@PostMapping("/cancelChange")
	@ResponseBody
	public void cancelReservationChange(@RequestParam("reservationChangeNo") String reservationChangeNo) {
		memberReservationService.cancelReservationChange(reservationChangeNo);
	}
	
	@GetMapping("/reservation")
	public void reservation() {}
	
	@GetMapping("/reservationChange")
	public void reservationChange() {}
	
	@SuppressWarnings("deprecation")
	@PostMapping("/selectSchedule")
	@ResponseBody
	public Map<String, ScheduleTimegridDTO> viewSchedule(@AuthenticationPrincipal UserImpl user) throws JsonProcessingException {
		Map<String, ScheduleTimegridDTO> scheduleMap = new HashMap<>();
		
		// 트레이너 아이디 조회 
		String trnId = memberReservationService.findTrnId(user.getId());
		
		// 트레이너 스케줄 조회 
		List<TrainerScheduleDTO> scheduleList = memberReservationService.findScheduleById(trnId);
		for(int i = 0; i < scheduleList.size(); i++) {
			TrainerScheduleDTO schedule = scheduleList.get(i);
			
			String daysOfWeek = "";
			String day = schedule.getSchName();
			switch(day) {
				case "월": daysOfWeek = "[1, 1]"; break;
				case "화": daysOfWeek = "[2, 2]"; break;
				case "수": daysOfWeek = "[3, 3]"; break;
				case "목": daysOfWeek = "[4, 4]"; break;
				case "금": daysOfWeek = "[5, 5]"; break;
				case "토": daysOfWeek = "[6, 6]"; break;
				case "일": daysOfWeek = "[0, 0]"; break;
			}
			
			int start = schedule.getSchStart();
			String startTime = start + ":00:00";
			
			int end = schedule.getSchEnd();
			String endTime = end + ":00:00";
			
			String backgroundColor = "";
			String groupId = "";
			String type = schedule.getSchWeek();
			switch(type) {
				case "근무": backgroundColor = "green"; groupId = "able"; break;
				case "점심": backgroundColor = "white"; groupId = "disable"; break;
				case "휴무": backgroundColor = "white"; groupId = "disable"; break;
			}
			
			scheduleMap.put("schEvent" + i, new ScheduleTimegridDTO(daysOfWeek, startTime, endTime, "background", backgroundColor, groupId));
		}
		
		return scheduleMap;
	}
	
	@SuppressWarnings("deprecation")
	@PostMapping("/selectHoliday")
	@ResponseBody
	public Map<String, HolidayTimegridDTO> viewHoliday(@AuthenticationPrincipal UserImpl user) throws JsonProcessingException {
		Map<String, HolidayTimegridDTO> holidayMap = new HashMap<>();
		
		// 트레이너 아이디 조회 
		String trnId = memberReservationService.findTrnId(user.getId());
		
		// 트레이너 휴가 조회 
		List<HolidayDTO> holidayList = memberReservationService.findHolidyById(trnId);
		for(int i = 0; i < holidayList.size(); i++) {
			HolidayDTO holiday = holidayList.get(i);
			
			Date hDay = holiday.getHDay();
			int hDayYear = hDay.getYear() + 1900;
			String hDayMonth = "0" + (hDay.getMonth() + 1);
			hDayMonth = hDayMonth.substring(0, 2);
			String hDayDay = "0" + hDay.getDate();
			hDayDay = hDayDay.substring(0, 2);
			
			String start = hDayYear + "-" + hDayMonth + "-" + hDayDay;
			
			holidayMap.put("holidayEvent" + i, new HolidayTimegridDTO(start, "background", "red", "disable"));
		}
		
		return holidayMap;
	}
	
	@SuppressWarnings("deprecation")
	@PostMapping("/selectReservation")
	@ResponseBody
	public Map<String, ReservationTimegridDTO> viewReservation(@AuthenticationPrincipal UserImpl user) throws JsonProcessingException {
		Map<String, ReservationTimegridDTO> reservationMap = new HashMap<>();
	
		String trnId = memberReservationService.findTrnId(user.getId());
		System.out.println("트레이너 아이디: " + trnId);
		
		// 예약 이미 된 것 조회 
		List<ReservationDTO> reservationList = memberReservationService.findReservationByTrnId(trnId);
		for(int i = 0; i < reservationList.size(); i++) {
			ReservationDTO reservation = reservationList.get(i);
			
			Date datetime = reservation.getDatetime();
			int datetimeYear = datetime.getYear() + 1900;
			String datetimeMonth = "0" + (datetime.getMonth() + 1);
			datetimeMonth = datetimeMonth.substring(datetimeMonth.length()-2, datetimeMonth.length());
			String datetimeDay = "0" + datetime.getDate();
			datetimeDay = datetimeDay.substring(datetimeDay.length()-2, datetimeDay.length());
			String datetimeHour = "0" + datetime.getHours();
			datetimeHour = datetimeHour.substring(datetimeHour.length()-2, datetimeHour.length());
			
			String start = datetimeYear + "-" + datetimeMonth + "-" + datetimeDay + "T" + datetimeHour + ":00:00";
			String end = datetimeYear + "-" + datetimeMonth + "-" + datetimeDay + "T" + (datetimeHour + 1) + ":00:00";
			
			System.out.println(start);
			
			reservationMap.put("rsvEvent" + i, new ReservationTimegridDTO(start, end, "background", "red", "disable"));
		}
		
		return reservationMap;
	}
	
	@PostMapping("/insertReservation")
	@ResponseBody
	public void insertReservation(@RequestParam("rsvDatetime") String rsvDatetime, @AuthenticationPrincipal UserImpl user) {
		String memberId = user.getId();
		String trnId = memberReservationService.findTrnId(user.getId());
		
		System.out.println("rsvDatetime: " + rsvDatetime);
		int year = Integer.parseInt(rsvDatetime.substring(0, 4));
		int month = Integer.parseInt(rsvDatetime.substring(5, 7));
		int day = Integer.parseInt(rsvDatetime.substring(8, 10));
		int hour = Integer.parseInt(rsvDatetime.substring(11, 13));
		
		// 날짜 계산 
		Calendar cal = Calendar.getInstance();
		cal.set(year, month - 1, day, hour, 0);
		Date datetime = new Date(cal.getTimeInMillis());
		
		memberReservationService.insertReservation(memberId, trnId, datetime);
	}
	
	@PostMapping("/insertReservationChange")
	@ResponseBody
	public void insertReservationChange(@RequestParam("rsvDatetime") String rsvDatetime, @RequestParam("reservationNo") String reservationNo ,@AuthenticationPrincipal UserImpl user) {
		String memberId = user.getId();
		
		System.out.println("rsvDatetime: " + rsvDatetime);
		int year = Integer.parseInt(rsvDatetime.substring(0, 4));
		int month = Integer.parseInt(rsvDatetime.substring(5, 7));
		int day = Integer.parseInt(rsvDatetime.substring(8, 10));
		int hour = Integer.parseInt(rsvDatetime.substring(11, 13));
		
		// 날짜 계산 
		Calendar cal = Calendar.getInstance();
		cal.set(year, month - 1, day, hour, 0);
		Date datetime = new Date(cal.getTimeInMillis());
		
		memberReservationService.insertReservationChange(memberId, reservationNo, datetime);
	}
	
	@PostMapping("/findAlertInfo")
	@ResponseBody
	public Object findAlertInfo(@AuthenticationPrincipal UserImpl user) {
		Map<String, String> map = new HashMap<>();
		
		map.put("userId", user.getId());
		map.put("userName", user.getName());
		
		String trnId = memberReservationService.findTrnId(user.getId());
		
		map.put("memberId", trnId);
		
		return map;
	}
	
}
