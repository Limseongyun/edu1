package com.example.demo.config.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.example.demo.config.RVO;
import com.google.gson.Gson;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class JwtUnAuthenticationEntryPoint implements AuthenticationEntryPoint{
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		log.debug("[JwtAuthenticationEntryPoint]! err: {}, {}", authException.getMessage(), request.getRequestURI());
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(new Gson().toJson(RVO.builder().msg("인증에 실패하였습니다.").data(authException.getMessage()).code("9999").build()));
	}
}
