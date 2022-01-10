package com.example.demo.config.security;
import java.util.Date;

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
		try {
			Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(token);
			return true;
		} catch (SignatureException ex) {
			log.error("Invalid JWT signature");
			throw new RuntimeException("��ȿ���� ���� JWT ���� �Դϴ�.");
		} catch (MalformedJwtException ex) {
			log.error("Invalid JWT token");
			throw new RuntimeException("��ȿ���� ���� JWT �Դϴ�.");
		} catch (ExpiredJwtException ex) {
			log.error("Expired JWT token");
			throw new RuntimeException("��ū�� ����Ǿ����ϴ�.");
		} catch (UnsupportedJwtException ex) {
			throw new RuntimeException("�������� �ʴ� JWT �Դϴ�.");
		} catch (IllegalArgumentException ex) {
			throw new RuntimeException("JWT �� claim�� ������ϴ�.");
		}
	}
}
