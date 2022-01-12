package com.example.demo.config.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.cmm.code.ApiCode;
import com.example.demo.cmm.utils.RVO;

@RestControllerAdvice
public class MyRestControllerAdvice {
	@ExceptionHandler(Exception.class)
	public RVO<String> err(Exception ex, HttpServletResponse resp, HttpServletRequest req) {
		//Object errCode = req.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		//log.debug("{}, {}, {}", req, resp, errCode);
		//만약 웹에서 온경우라면 ErrorController에서 다시 받도록하기위하여 exception을 다시 발생시켜준다.
		if(req.getRequestURI().startsWith("/public")) {
			throw new RuntimeException("오류발생");
		}
		
		if(ex instanceof RuntimeException) {
			//TODO: 익셉션별 response 부여 고려?
			resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		} else {
			resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
		ex.printStackTrace();
		return RVO.<String>builder().code(ApiCode.DEFAULT_ERR).msg("오류가 발생했 습니다.").data(ex.getMessage()).build();
	}
}
