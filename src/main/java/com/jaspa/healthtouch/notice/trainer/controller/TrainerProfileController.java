package com.jaspa.healthtouch.notice.trainer.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/notice")
public class TrainerProfileController {
	
	//트레이너 소개 조회
	@GetMapping("/trainerintro")
	public String trainerIntro() {		
			
	return "notice/trainerintro";
		}
	
	//트레이너 후기 조회(서현승)
	@GetMapping("/trainerprofile")
	public String trainerprofile() {		
			
		return "notice/trainerprofile";
	}
	

	//트레이너 후기 조회(남지현)
	@GetMapping("/trainerprofile1")
	public String trainerprofile1() {		
			
		return "notice/trainerprofile1";
	}
	
	//트레이너 후기 조회(허승준)
	@GetMapping("/trainerprofile2")
	public String trainerprofile2() {		
			
		return "notice/trainerprofile2";
	}
	
	//트레이너 후기 조회(한주은)
		@GetMapping("/trainerprofile3")
		public String trainerprofile3() {		
				
			return "notice/trainerprofile3";
		}
}