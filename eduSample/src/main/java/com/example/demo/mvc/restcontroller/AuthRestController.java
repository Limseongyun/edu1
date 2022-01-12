package com.example.demo.mvc.restcontroller;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.cmm.code.ApiCode;
import com.example.demo.cmm.utils.RVO;
import com.example.demo.mvc.model.dto.UserJoinDto;
import com.example.demo.mvc.model.entity.User;
import com.example.demo.mvc.repos.UserRepo;
import com.example.demo.mvc.service.AuthService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@Transactional
@RequestMapping("/api/v1/auth")
public class AuthRestController {
	@Autowired AuthService asService;
	@Autowired UserRepo userRepo;
	
	@Operation(summary = "JWT 토큰발급", description = "ID, PW를 통해 JWT를 발급받습니다.")
	@GetMapping("/token")
	public RVO<String> getToken(@RequestParam String userId, @RequestParam String userPw, @RequestParam(required = false) Boolean isMngLogin) {
		return RVO.<String>builder()
				.code(ApiCode.NORMAL)
				.msg("JWT 토큰이 발급되었습니다.")
				.data(asService.getToken(userId, userPw, isMngLogin))
				.build();
	}
	
	@PostMapping("/userJoin")
	public RVO<User> userJoin(@RequestBody UserJoinDto dto) {
		return RVO.<User>builder()
				.code(ApiCode.NORMAL)
				.msg("사용자 가입이 완료되었습니다.")
				.data(asService.userJoin(dto))
				.build();
	}
	
	@PostMapping("/mngJoin")
	public RVO<User> mngJoin(@RequestBody UserJoinDto dto) {
		return RVO.<User>builder()
				.code(ApiCode.NORMAL)
				.msg("관리자 가입이 완료되었습니다.")
				.data(asService.mngJoin(dto))
				.build();
	}
	
	@PostMapping("/reSign")
	public RVO<User> reSign() {
		return RVO.<User>builder()
				.code(ApiCode.NORMAL)
				.msg("탈퇴 완료되었습니다.")
				.data(asService.reSign())
				.build();
	}
}
