package com.jaspa.healthtouch.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

public class LoginFailHandler implements AuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		String errorMessage = "알 수 없는 이유로 로그인에 실패했습니다.";
		
		if(exception instanceof InternalAuthenticationServiceException) {
			errorMessage = "해당 아이디가 존재하지 않습니다. 회원 가입해 주세요.";
		}
		
		if(exception instanceof BadCredentialsException) {
			errorMessage = "아이디 또는 비밀번호가 일치하지 않습니다.";
		}
		
		request.getRequestDispatcher("/member/login?errorMessage=" + errorMessage).forward(request, response);
	}

}
