package com.example.demo.mvc.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.cmm.code.ApiCode;
import com.example.demo.cmm.code.Code;
import com.example.demo.cmm.utils.EntityUtil;
import com.example.demo.cmm.utils.RVO;
import com.example.demo.config.security.JwtTokenProvider;
import com.example.demo.mvc.model.dto.UserJoinDto;
import com.example.demo.mvc.model.entity.User;
import com.example.demo.mvc.model.entity.UserRole;
import com.example.demo.mvc.repos.UserRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AuthService {
	@Autowired private UserRepo userRepo;
	@Autowired private PasswordEncoder pe;
	@Autowired private EntityUtil eu;
	@Autowired private ModelMapper mm;
	
	//����
	public RVO<User> userJoin(UserJoinDto dto) {
		return joinCmmn(dto, Code.USER_TY_USR);
	}
	
	//������ ����
	public RVO<User> mngJoin(UserJoinDto dto) {
		return joinCmmn(dto, Code.USER_TY_MNG);
	}
	
	private RVO<User> joinCmmn(UserJoinDto dto, String codeValue) {
		if(dto.getUserId() != null 
				&& userRepo.findByUserId(dto.getUserId()) != null) throw new RuntimeException("�̹� �����ϴ� ���� �Դϴ�.");
		User user = mm.map(dto, User.class);
		user.setUserPw(pe.encode(user.getPassword()));
		user.setUserSttusCode(eu.getUserSttusCmm(Code.USER_STTUS_OK));
		user.setUserTyCode(eu.getUserTyCmm(codeValue));
		UserRole uRole = new UserRole();
		if(codeValue.equals(Code.USER_TY_MNG)) uRole.setRoleTyCode(eu.getRoleTyCmm(Code.ROLE_TY_MNG));
		if(codeValue.equals(Code.USER_TY_USR)) uRole.setRoleTyCode(eu.getRoleTyCmm(Code.ROLE_TY_USR));
		user.addRoles(uRole);
		userRepo.save(user);
		log.debug("saveUsers: {}", user);
		return RVO.<User>builder().msg("���ԵǾ����ϴ�.").data(user).code(ApiCode.NORMAL).build();
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
		if("01".equals(u.getUserSttusCode().getCodeValue())){
			return true;
		} else {
			return false;
		}
	}
	
	//Ż��
	public RVO<User> reSign(){
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		if(name == null || Code.ANNONYMOUSE_USER.equals(name)) throw new RuntimeException("Ż��� �α����� �ؾ� �մϴ�.");
		log.debug("name is {}", name);
		User user = userRepo.findById(Long.parseLong(name)).get();
		if(user.getUserTyCode().getCodeValue().equals(Code.ROLE_TY_ADM)) throw new RuntimeException("������ Ż���Ҽ� �����ϴ�.");
		if(user.getUserSttusCode().getCodeValue().equals(Code.USER_STTUS_RESIGN)) throw new RuntimeException("�̹� Ż��� ȸ���Դϴ�.");
		user.setUserSttusCode(eu.getUserSttusCmm(Code.USER_STTUS_RESIGN));
		User reSignUser = userRepo.save(user);
		return RVO.<User>builder()
				.code(ApiCode.NORMAL)
				.msg("Ż��Ǿ����ϴ�.")
				.data(reSignUser)
				.build();
	}
}
