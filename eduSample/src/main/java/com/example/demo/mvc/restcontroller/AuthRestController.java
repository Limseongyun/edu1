package com.example.demo.mvc.restcontroller;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.cmm.code.ApiCode;
import com.example.demo.cmm.utils.RVO;
import com.example.demo.mvc.model.dto.UserJoinDto;
import com.example.demo.mvc.model.dto2.MemJoinDto;

import com.example.demo.mvc.model.entity3.Member;
import com.example.demo.mvc.repos.MemberRepo;
import com.example.demo.mvc.service.MemberSvc;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@Transactional
@RequestMapping("/api/v1/auth")
public class AuthRestController {
	@Autowired MemberSvc s;
	
	@Operation(summary = "JWT 토큰발급", description = "ID, PW를 통해 JWT를 발급받습니다.")
	@GetMapping("/token")
	public RVO<String> getToken(@RequestParam String userId, @RequestParam String userPw, @RequestParam(required = false) Boolean isMngLogin) {
		return RVO.<String>builder()
				.code(ApiCode.NORMAL)
				.msg("JWT 토큰이 발급되었습니다.")
				.data(s.token(userId, userPw))
				.build();
	}
	
	@PostMapping("/userJoin")
	public RVO<Member> userJoin(@RequestBody MemJoinDto dto) {
		return RVO.<Member>builder()
				.code(ApiCode.NORMAL)
				.msg("사용자 가입이 완료되었습니다.")
				.data(s.userjoin(dto))
				.build();
	}
	
	@PostMapping("/sellerJoin")
	public RVO<Member> mngJoin(@RequestBody MemJoinDto dto) {
		return RVO.<Member>builder()
				.code(ApiCode.NORMAL)
				.msg("판매자 가입이 완료되었습니다.")
				.data(s.sellerjoin(dto))
				.build();
	}
	
	@PostMapping("/reSign")
	public RVO<Member> reSign() {
		return RVO.<Member>builder()
				.code(ApiCode.NORMAL)
				.msg("탈퇴 완료되었습니다.")
				.data(s.resign(String.valueOf(SecurityContextHolder.getContext().getAuthentication().getPrincipal())))
				.build();
	}
}
