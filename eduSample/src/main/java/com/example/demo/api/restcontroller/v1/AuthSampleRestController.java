package com.example.demo.api.restcontroller.v1;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.api.service.AuthSampleService;
import com.example.demo.config.RVO;
import com.example.demo.config.security.JwtTokenProvider;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthSampleRestController {
	@Autowired AuthSampleService asService;
	
	@GetMapping("/token")
	public RVO<String> getToken(@RequestParam String userId, @RequestParam String userPw) {
		//return JwtTokenProvider.generateToken(new UsernamePasswordAuthenticationToken("a",null));
		return asService.getToken(userId, userPw);
	}
	
	@GetMapping("/test")
	public RVO<String> test() {
		List<String> a = new ArrayList<>();
		a.add("aa");
		return RVO.<String>builder()
				.code("0000")
				.msg("gd")
				.data("ssS").build();
	}
}
