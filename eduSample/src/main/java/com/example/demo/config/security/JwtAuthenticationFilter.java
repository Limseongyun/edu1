package com.example.demo.config.security;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JwtAuthenticationFilter extends OncePerRequestFilter{
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		//log.debug("[JwtAuthenticationFilter]{}, {}", request.getRequestURI(), request.getHeader("Authorization"));
		
		//TODO stsrt with /api로 시작하면 jwt 토큰 인증을하고 그게아니라면 session 인증방식을 사용한다.
		if(request.getRequestURI().startsWith("/api")) {
			jwtAuthStart(request);
		} else {
			
		}
		filterChain.doFilter(request, response);
	}
	
	private void jwtAuthStart(HttpServletRequest request) {
		try {
			String jwt = getJwtFromRequest(request);
			if(jwt != null && JwtTokenProvider.validateToken(jwt, request)) {
				String userSn = JwtTokenProvider.getUserSnFromJwt(jwt);
				
				Set<GrantedAuthority> roles = new HashSet<GrantedAuthority>();
				//roles.add(new SimpleGrantedAuthority("ROLE_USER"));
				//TODO ROLE
				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userSn, null, roles);
				//TODO ?
				authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				//authentication.setAuthenticated(true);
				SecurityContextHolder.getContext().setAuthentication(authentication);
			} else {
				//if(jwt == null) request.setAttribute("unauthorization", "����Ű ����");
				//if(! JwtTokenProvider.validateToken(jwt)) request.setAttribute("unauthorization", "����Ű ����");
			}
		} catch (Exception e) {
			log.debug("인증과정중 오류 발생, {}", e.getMessage());
		}
	}
	
	private String getJwtFromRequest(HttpServletRequest req) {
		String bearerToken = req.getHeader("Authorization");
		if(bearerToken != null && bearerToken.startsWith("Bearer ")) {
			return bearerToken.substring("Bearer ".length());
		}
		return null;
	}
}
