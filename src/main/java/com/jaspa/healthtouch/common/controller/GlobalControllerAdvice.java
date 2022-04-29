package com.jaspa.healthtouch.common.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalControllerAdvice {
	@ExceptionHandler(value=Exception.class)
	public String exception(Exception e, Model model) {
		model.addAttribute("errorMessage", e.getMessage());
		return "error/error";
	}
}
