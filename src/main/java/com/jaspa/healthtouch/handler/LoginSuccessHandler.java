package com.jaspa.healthtouch.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.jaspa.healthtouch.login.model.dto.LoginLogDTO;
import com.jaspa.healthtouch.login.model.dto.UserImpl;
import com.jaspa.healthtouch.login.model.service.MemberService;

public class LoginSuccessHandler implements AuthenticationSuccessHandler {
	
	private MemberService memberService;

	public LoginSuccessHandler(MemberService memberService) {
		this.memberService = memberService;
	}

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		UserImpl user = (UserImpl) authentication.getPrincipal();
		LoginLogDTO loginLog = new LoginLogDTO();
		
		// 로그인 기록 남기기 
		loginLog.setMemberId(user.getId());
		loginLog.setIp(getClientIp(request));
		
		memberService.createLoginLog(loginLog);
		
		// 회원이면 
		if(user.getMemberRole().getAuthorityCode() == 1) {
			response.sendRedirect("/member/mypage");
		} else if(user.getMemberRole().getAuthorityCode() == 2) {
			response.sendRedirect("/trainer/trainer-info");
		}
		else {
			response.sendRedirect("/");
		}
	}
	
	public static String getClientIp(HttpServletRequest request) {
		String ip = request.getHeader("X-Forwarded-For");
		
		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
				
		return ip;
	}

}