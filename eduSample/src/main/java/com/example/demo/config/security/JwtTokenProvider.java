package com.example.demo.config.security;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JwtTokenProvider {
	// TODO: @Value
	private final static String JWT_SECRET = "password";
	private final static int JWT_EXPIRATION_MS = 1000 * 60 * 10;
	
	public static String generateToken(Authentication auth) {
		return Jwts.builder()
				.setSubject((String) auth.getPrincipal())
				.setIssuedAt(new Date())
				.setExpiration(new Date(new Date().getTime() + JWT_EXPIRATION_MS))
				.signWith(SignatureAlgorithm.HS512, JWT_SECRET)
				.compact();
	}
	
	public static String getUserSnFromJwt(String jwt) {
		Claims claims = Jwts.parser()
				.setSigningKey(JWT_SECRET)
				.parseClaimsJws(jwt)
				.getBody();
		return claims.getSubject();
	}
	
	public static boolean validateToken(String token) {
		return validateTokenSub(token, null);
	}
	
	public static boolean validateToken(String token, HttpServletRequest req) {
		return validateTokenSub(token, req);
	}
	
	private static boolean validateTokenSub(String token, HttpServletRequest req) {
		try {
			Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(token);
			return true;
		} catch (SignatureException ex) {
			String err = "��ȿ���� ���� JWT ���� �Դϴ�.";
			log.error(err);
			if(req != null) req.setAttribute("unauthorization", err);
		} catch (MalformedJwtException ex) {
			String err = "�߸��� JWT �Դϴ�.";
			log.error(err);
			if(req != null) req.setAttribute("unauthorization", err);
		} catch (ExpiredJwtException ex) {
			String err = "��ū�� ����Ǿ����ϴ�.";
			log.error(err);
			if(req != null) req.setAttribute("unauthorization", err);
		} catch (UnsupportedJwtException ex) {
			String err = "�������� �ʴ� JWT �Դϴ�.";
			log.error(err);
			if(req != null) req.setAttribute("unauthorization", err);
		} catch (IllegalArgumentException ex) {
			String err = "JWT �� claim�� ������ϴ�.";
			log.error(err);
			if(req != null) req.setAttribute("unauthorization", err);
		}
		return false;
	}
}
