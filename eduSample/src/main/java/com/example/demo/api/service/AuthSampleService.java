package com.example.demo.api.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.config.RVO;
import com.example.demo.config.code.ApiCode;
import com.example.demo.config.code.Code;
import com.example.demo.config.security.JwtTokenProvider;
import com.example.demo.model.dto.UserJoinDto;
import com.example.demo.model.entity.User;
import com.example.demo.model.repo.UserRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AuthSampleService {
	@Autowired private UserRepo userRepo;
	@Autowired private PasswordEncoder pe;
	
	//����
	public RVO<User> userJoin(UserJoinDto dto) {
		return joinCmmn(dto, Code.ROLE_TY_USR);
	}
	
	//������ ����
	public RVO<User> mngJoin(UserJoinDto dto) {
		return joinCmmn(dto, Code.ROLE_TY_MNG);
	}
	
	private RVO<User> joinCmmn(UserJoinDto dto, String userTyCode) {
		if(dto.getUserId() != null 
				&& userRepo.findByUserId(dto.getUserId()) != null) throw new RuntimeException("�̹� �����ϴ� ���� �Դϴ�.");
		ModelMapper mm = new ModelMapper();
		User user = mm.map(dto, User.class);
		user.setUserPw(pe.encode(user.getPassword()));
		user.setUserSttusCode(Code.USER_STTUS_OK);
		user.setUserTyCode(userTyCode);
		User joinedUsr = userRepo.save(user);
		return RVO.<User>builder().msg("���ԵǾ����ϴ�.").data(joinedUsr).code(ApiCode.NORMAL).build();
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
						.code(ApiCode.NORMAL)
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
