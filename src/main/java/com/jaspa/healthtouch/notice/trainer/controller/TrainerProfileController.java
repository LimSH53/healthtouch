package com.jaspa.healthtouch.notice.trainer.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/notice")
public class TrainerProfileController {

	
	@GetMapping("/trainerintro")
	public String trainerIntro() {		
		
		return "notice/trainerintro";
	}
	
	@GetMapping("/trainerprofile")
	public String trainerProfile() {		
		
		return "notice/trainerprofile";
	}
	
	
	
	@GetMapping("/trainerprofile1")
	public String trainerProfile1() {		
		
		return "notice/trainerprofile1";
	}
	 
	
	@GetMapping("/trainerprofile2")
	public String trainerProfile2() {		
		
		return "notice/trainerprofile2";
	}
	
	@GetMapping("/trainerprofile3")
	public String trainerProfile3() {		
		
		return "notice/trainerprofile3";
	}
 
}