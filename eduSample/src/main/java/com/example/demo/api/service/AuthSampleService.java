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
	
	//����
	public void userJoin() {
		
	}
	
	//Ż��
	public void userResign() {
		
	}
	
	//LOGIN
	public RVO<String> getToken(String userId, String userPw) {
		User user = userRepo.findByUserId(userId);
		if(user != null) {
			if(pe.matches(userPw, user.getPassword())) {
				if(!userIsValid(user)) throw new RuntimeException("���� ���°� ������ �ƴմϴ�.");
				return RVO.<String>builder()
						.msg("jwt ��ū�� �߱޵Ǿ����ϴ�.")
						.code("0000")
						.data(JwtTokenProvider.generateToken(new UsernamePasswordAuthenticationToken(String.valueOf(user.getUserSn()), null)))//TODO:ROLE
						.build();
			} else {
				throw new RuntimeException("�ùٸ��� ���� ��й�ȣ �Դϴ�..");
			}
		} else {
			throw new RuntimeException("������ �ʴ� ���� �Դϴ�.");
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
