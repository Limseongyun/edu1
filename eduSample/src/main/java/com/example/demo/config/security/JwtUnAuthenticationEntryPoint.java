package com.example.demo.config.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.example.demo.cmm.code.ApiCode;
import com.example.demo.cmm.utils.RVO;
import com.google.gson.Gson;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class JwtUnAuthenticationEntryPoint implements AuthenticationEntryPoint{
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		log.debug("[JwtAuthenticationEntryPoint]! err: {}, {}", authException.getMessage(), request.getRequestURI());
		if(request.getRequestURI().startsWith("/api")) {
			String msg = String.valueOf(request.getAttribute("unauthorization"));
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			response.setContentType("application/json;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print(new Gson().toJson(RVO.builder().msg("JWT 인증에 실패 하였습니다.").data(msg != null ? msg : authException.getMessage()).code(ApiCode.NOT_AUTH).build()));
		} else {
			response.sendRedirect("/public/loginPage");
			//response.sendError(HttpServletResponse.SC_UNAUTHORIZED, authException.getMessage());
		}
	}
}
