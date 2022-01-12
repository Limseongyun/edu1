package com.example.demo.mvc.service;

import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.cmm.code.Code;
import com.example.demo.cmm.utils.EntityUtil;
import com.example.demo.config.security.JwtTokenProvider;
import com.example.demo.mvc.model.dto.UserJoinDto;
import com.example.demo.mvc.model.entity.QUser;
import com.example.demo.mvc.model.entity.User;
import com.example.demo.mvc.model.entity.UserRole;
import com.example.demo.mvc.repos.UserRepo;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthService {
	private final UserRepo userRepo;
	private final PasswordEncoder pe;
	private final EntityUtil eu;
	private final ModelMapper mm;
	private final JPAQueryFactory qf;
	
	//사용자 가입
	public User userJoin(UserJoinDto dto) {
		return joinCmmn(dto, Code.USER_TY_USR);
	}
	
	//관리자 가입
	public User mngJoin(UserJoinDto dto) {
		return joinCmmn(dto, Code.USER_TY_MNG);
	}
	
	private User joinCmmn(UserJoinDto dto, String codeValue) {
		QUser quser = QUser.user;
		Integer userCnt = qf.select(quser)
							.from(quser)
							.where(quser.userTyCode.eq(codeValue.equals(Code.USER_TY_MNG) ? eu.getUserTyCmm(Code.USER_TY_MNG) : eu.getUserTyCmm(Code.USER_TY_USR))
								.and(quser.userId.eq(dto.getUserId())))
							.fetch().size();
		
		if(userCnt > 0) throw new RuntimeException("이미 존재하는 유저 입니다.");
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
		return user;
	}
	
	//LOGIN
	public String getToken(String userId, String userPw, Boolean isMngLogin) {
		QUser quser = QUser.user;
		User user = qf.select(quser)
							.from(quser)
							.where(quser.userTyCode.eq(isMngLogin != null && isMngLogin ? eu.getUserTyCmm(Code.USER_TY_MNG) : eu.getUserTyCmm(Code.USER_TY_USR))
								.and(quser.userId.eq(userId)))
							.fetchOne();
		if(user != null) {
			if(pe.matches(userPw, user.getPassword())) {
				if(!userIsValid(user)) throw new RuntimeException("유저상태가 이상합니다.");
				return JwtTokenProvider.generateToken(new UsernamePasswordAuthenticationToken(String.valueOf(user.getUserSn()), null));
			} else {
				throw new RuntimeException("비밀번호가 틀립니다.");
			}
		} else {
			throw new RuntimeException("존재하지 않는 유저 입니다.");
		}
	}
	
	private boolean userIsValid(User u) {
		if("01".equals(u.getUserSttusCode().getCodeValue())){
			return true;
		} else {
			return false;
		}
	}
	
	//탈퇴
	public User reSign(){
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		if(name == null || Code.ANNONYMOUSE_USER.equals(name)) throw new RuntimeException("탈퇴하려면 토큰을 가지고 있어야 합니다.(로그인필요)");
		log.debug("name is {}", name);
		User user = userRepo.findById(Long.parseLong(name)).get();
		if(user.getUserTyCode().getCodeValue().equals(Code.ROLE_TY_ADM)) throw new RuntimeException("어드민은 삭제할수 없습니다.");
		if(user.getUserSttusCode().getCodeValue().equals(Code.USER_STTUS_RESIGN)) throw new RuntimeException("이미 탈퇴된 유저 입니다.");
		user.setUserSttusCode(eu.getUserSttusCmm(Code.USER_STTUS_RESIGN));
		User reSignUser = userRepo.save(user);
		return reSignUser;
	}
}
