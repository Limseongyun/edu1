package com.example.demo.config.exception;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class MyControllerAdvice {
	@ExceptionHandler(Exception.class)
	public String notFound(Exception e, Model model) {
		log.debug("hi1 {}", e.getMessage());
		model.addAttribute("msg", e.getMessage());
		return "/error/ErrorPage";
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public String notFound2(Exception e, Model model) {
		log.debug("hi2 {}", e.getMessage());
		model.addAttribute("msg", e.getMessage());
		return "/error/ErrorPage";
	}

}
