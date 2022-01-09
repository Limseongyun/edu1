package com.example.demo.api.restcontroller.v1;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.config.security.JwtTokenProvider;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthSampleRestController {
	@GetMapping("/getToken")
	public String getToken() {
		return JwtTokenProvider.generateToken(new UsernamePasswordAuthenticationToken("a",null));
	}
}
