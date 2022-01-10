package com.example.demo.config.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.config.RVO;
import com.example.demo.config.code.ApiCode;

@RestControllerAdvice
public class MyRestControllerAdvice {
	@ExceptionHandler(Exception.class)
	public RVO<String> err(Exception ex, HttpServletResponse resp, HttpServletRequest req) {
		//Object errCode = req.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		//log.debug("{}, {}, {}", req, resp, errCode);
		if(ex instanceof RuntimeException) {
			//TODO: �ͼ��Ǻ� response �ο� ���?
			resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		} else {
			resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
		//ex.printStackTrace();
		return RVO.<String>builder().code(ApiCode.DEFAULT_ERR).msg("������ �߻��� ���ϴ�.").data(ex.getMessage()).build();
	}
}
