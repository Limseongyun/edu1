package com.example.demo.config.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.config.RVO;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestControllerAdvice
public class MyRestControllerAdvice {
	@ExceptionHandler(Exception.class)
	public RVO err(Exception ex) {
		log.debug("aa");
		return RVO.builder().code("9999").msg("no").data(ex.getMessage()).build();
	}
}
