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
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class JwtAuthenticationFilter extends OncePerRequestFilter{
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		log.debug("[JwtAuthenticationFilter]{}, {}", request.getRequestURI(), request.getHeader("Authorization"));
		try {
			String jwt = getJwtFromRequest(request);
			if(! jwt.isEmpty() && JwtTokenProvider.validateToken(jwt)) {
				String userSn = JwtTokenProvider.getUserSnFromJwt(jwt);
				
				Set<GrantedAuthority> roles = new HashSet<GrantedAuthority>();
				roles.add(new SimpleGrantedAuthority("ROLE_USER"));
				//TODO ROLE
				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userSn, null, roles);
				//TODO ?
				authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				
				SecurityContextHolder.getContext().setAuthentication(authentication);
			} else {
				if(! jwt.isEmpty()) request.setAttribute("unauthorization", "인증키 없음");
				if(! JwtTokenProvider.validateToken(jwt)) request.setAttribute("unauthorization", "인증키 만료");
			}
		} catch (Exception e) {
			log.debug("유저정보를 securityContext에 넣는데 실패함, {}", e.getMessage());
		}
		filterChain.doFilter(request, response);
	}
	
	private String getJwtFromRequest(HttpServletRequest req) {
		String bearerToken = req.getHeader("Authorization");
		if(! bearerToken.isEmpty() && bearerToken.startsWith("Bearer ")) {
			return bearerToken.substring("Bearer ".length());
		}
		return null;
	}
}
