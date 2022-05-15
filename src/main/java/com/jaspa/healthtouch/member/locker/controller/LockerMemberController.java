package com.jaspa.healthtouch.member.locker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jaspa.healthtouch.login.model.dto.UserImpl;
import com.jaspa.healthtouch.member.locker.model.dto.LockerDTO;
import com.jaspa.healthtouch.member.locker.model.service.LockerMemberService;
import com.jaspa.healthtouch.trainer.trainerInfo.model.dto.TrainerMemberDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/member/product")
public class LockerMemberController {

	
	private LockerMemberService lockerMemberService;
	
	
	@Autowired
	public LockerMemberController(LockerMemberService lockerMemberService) {
		this.lockerMemberService = lockerMemberService;
	}
	
	
	@GetMapping("/lockerAll")
	public ModelAndView selectAllLocker(ModelAndView mv) {
		
		List<LockerDTO> lockerList = lockerMemberService.selectAllLocker();
		
		log.info("lockerList : {}", lockerList);
		
		mv.addObject("lockerList", lockerList);
		mv.setViewName("member/product/locker-site");

		
		return mv;
	}
	
	
	
	
	
	
	
	@GetMapping("/updateLocker")
	public void updateLocker(Model model, @AuthenticationPrincipal UserImpl user) {
		
		LockerDTO lockerInfo = lockerMemberService.updateLocker(user.getId());
		model.addAttribute("lockerInfo", lockerInfo);
		
		log.info(lockerInfo.toString());
	}
	
	
	@PostMapping("/updateLocker")
	public void updateLocker(TrainerMemberDTO trainer,  @AuthenticationPrincipal UserImpl user, Model model) {
		
		trainer.setId(user.getId());
		log.info(trainer.toString());
		trainerService.updateTrainer(trainer);
		
		TrainerMemberDTO trainerInfo = trainerService.selectTrainer(user.getId());
		model.addAttribute("trainerInfo", trainerInfo);
		
		user.setName(trainer.getName());
		user.setContact(trainer.getContact());
		user.setAddress(trainer.getAddress());
		user.setBirthday(trainer.getBirthday());
	}
	
	
	
	
	
	
	
	
	
	
	
}
