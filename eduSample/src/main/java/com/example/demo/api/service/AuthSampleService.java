package com.example.demo.api.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.demo.config.RVO;
import com.example.demo.config.code.ApiCode;
import com.example.demo.config.code.Code;
import com.example.demo.config.security.JwtTokenProvider;
import com.example.demo.model.dto.UserJoinDto;
import com.example.demo.model.entity.User;
import com.example.demo.model.entity.UserRole;
import com.example.demo.model.repo.UserRepo;
import com.example.demo.model.repo.UserRoleRepo;
import com.example.demo.utils.EntityUtil;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AuthSampleService {
	@Autowired private UserRepo userRepo;
	@Autowired private UserRoleRepo userRoleRepo;
	@Autowired private PasswordEncoder pe;
	@Autowired private EntityUtil eu;
	@Autowired private ModelMapper mm;
	
	//가입
	public RVO<User> userJoin(UserJoinDto dto) {
		return joinCmmn(dto, Code.USER_TY_USR);
	}
	
	//관리자 가입
	public RVO<User> mngJoin(UserJoinDto dto) {
		return joinCmmn(dto, Code.USER_TY_MNG);
	}
	
	private RVO<User> joinCmmn(UserJoinDto dto, String codeValue) {
		if(dto.getUserId() != null 
				&& userRepo.findByUserId(dto.getUserId()) != null) throw new RuntimeException("이미 존재하는 유저 입니다.");
		User user = mm.map(dto, User.class);
		user.setUserPw(pe.encode(user.getPassword()));
		user.setUserSttusCode(eu.getUserSttusCmm(Code.USER_STTUS_OK));
		user.setUserTyCode(eu.getUserTyCmm(codeValue));
		UserRole uRole = new UserRole();
		if(codeValue.equals(Code.USER_TY_MNG)) uRole.setRoleTyCode(eu.getRoleTyCmm(Code.ROLE_TY_MNG));
		if(codeValue.equals(Code.USER_TY_USR)) uRole.setRoleTyCode(eu.getRoleTyCmm(Code.ROLE_TY_USR));
		user.addRoles(uRole);
		userRepo.save(user);
		;
		log.debug("saveUsers: {}", user);
		return RVO.<User>builder().msg("가입되었습니다.").data(user).code(ApiCode.NORMAL).build();
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
						.code(ApiCode.NORMAL)
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
		if("01".equals(u.getUserSttusCode().getCodeValue())){
			return true;
		} else {
			return false;
		}
	}
	
	public RVO<User> reSign(){
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		if(name == null || Code.ANNONYMOUSE_USER.equals(name)) throw new RuntimeException("탈퇴는 로그인을 해야 합니다.");
		log.debug("name is {}", name);
		User user = userRepo.findById(Long.parseLong(name)).get();
		if(user.getUserTyCode().getCodeValue().equals(Code.ROLE_TY_ADM)) throw new RuntimeException("어드민은 탈퇴할수 없습니다.");
		if(user.getUserSttusCode().getCodeValue().equals(Code.USER_STTUS_RESIGN)) throw new RuntimeException("이미 탈퇴된 회원입니다.");
		user.setUserSttusCode(eu.getUserSttusCmm(Code.USER_STTUS_RESIGN));
		User reSignUser = userRepo.save(user);
		return RVO.<User>builder()
				.code(ApiCode.NORMAL)
				.msg("탈퇴되었습니다.")
				.data(reSignUser)
				.build();
	}
}
