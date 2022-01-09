package com.example.demo.config.exception;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.config.RVO;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestControllerAdvice
public class MyRestControllerAdvice {
	@ExceptionHandler(Exception.class)
	public RVO err(Exception ex, HttpServletResponse resp, HttpServletRequest req) {
		//Object errCode = req.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		//log.debug("{}, {}, {}", req, resp, errCode);
		if(ex instanceof RuntimeException) {
			//TODO: 익셉션별 response 부여 고려?
			resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		} else {
			resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
		return RVO.builder().code("9999").msg("오류가 발생했 습니다.").data(ex.getMessage()).build();
	}
}
