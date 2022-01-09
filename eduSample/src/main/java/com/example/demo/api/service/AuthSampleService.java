package com.example.demo.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.config.RVO;
import com.example.demo.config.security.JwtTokenProvider;
import com.example.demo.model.entity.User;
import com.example.demo.model.repo.UserRepo;

@Service
public class AuthSampleService {
	@Autowired UserRepo userRepo;
	@Autowired PasswordEncoder pe;
	
	//가입
	public void userJoin() {
		
	}
	
	//탈퇴
	public void userResign() {
		
	}
	
	//LOGIN
	public RVO<String> getToken(String userId, String userPw) {
		User user = userRepo.findByUserId(userId);
		if(user != null) {
			if(pe.matches(userPw, user.getPassword())) {
				if(!userIsValid(user)) throw new RuntimeException("유저 상태가 정상이 아닙니다.");
				return RVO.<String>builder()
						.msg("jwt 토큰이 발급되었습니다.")
						.code("0000")
						.data(JwtTokenProvider.generateToken(new UsernamePasswordAuthenticationToken(String.valueOf(user.getUserSn()), null)))//TODO:ROLE
						.build();
			} else {
				throw new RuntimeException("올바르지 못한 비밀번호 입니다..");
			}
		} else {
			throw new RuntimeException("존재지 않는 유저 입니다.");
		}
	}
	
	private boolean userIsValid(User u) {
		if("01".equals(u.getUserSttusCode())){
			return true;
		} else {
			return false;
		}
	}
}
