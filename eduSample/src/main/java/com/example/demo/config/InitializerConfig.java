package com.example.demo.config;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.config.code.Code;
import com.example.demo.model.entity.CmmnCodeDetail;
import com.example.demo.model.entity.User;
import com.example.demo.model.repo.CmmnCodeDetailRepo;
import com.example.demo.model.repo.UserRepo;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class InitializerConfig {
	@Autowired private PasswordEncoder pe;
	@Autowired private UserRepo userRepo;
	@Autowired private CmmnCodeDetailRepo ccdRepo;
	private final static String USER_TY_CODE = "user_ty_code";
	private final static String USER_STTUS_CODE = "user_sttus_code";
	
	private final static String ROLE_TY_CODE = "role_ty_code";
	
	@PostConstruct
	public void postCon() {
		log.debug("[start]");
		//TODO: 디폴트 DB값 체크
		
		//만약 ADMIN 아이디가 없으면 만들어준다.
		User admin = userRepo.findByUserId("admin");
		if(admin == null) {
			log.debug("admin insert!");
			User adm = new User();
			adm.setUserId("admin");
			adm.setUserNm("어드민");
			adm.setUserPw(pe.encode("admin"));
			adm.setUserTyCode(Code.USER_TY_MNG);
			adm.setUserSttusCode(Code.USER_STTUS_OK);
			userRepo.save(adm);
			
			User adm2 = new User();
			adm2.setUserId("admin2");
			adm2.setUserNm("어드민2");
			adm2.setUserPw(pe.encode("admin2"));
			adm2.setUserTyCode(Code.USER_TY_MNG);
			adm2.setUserSttusCode(Code.USER_STTUS_OK);
			userRepo.save(adm2);
		}
		
		List<CmmnCodeDetail> roleTyCode = ccdRepo.findByCodeId(ROLE_TY_CODE);
		if(roleTyCode.size() == 0) {
			log.debug("cmmncode insert!");
			CmmnCodeDetail adm = new CmmnCodeDetail();
			adm.setCodeId(ROLE_TY_CODE);
			adm.setCodeValue(Code.ROLE_TY_ADM);
			adm.setCodeValueNm("어드민");
			
			CmmnCodeDetail mng = new CmmnCodeDetail();
			mng.setCodeId(ROLE_TY_CODE);
			mng.setCodeValue(Code.ROLE_TY_MNG);
			mng.setCodeValueNm("관리자");
			
			CmmnCodeDetail usr = new CmmnCodeDetail();
			usr.setCodeId(ROLE_TY_CODE);
			usr.setCodeValue(Code.ROLE_TY_USR);
			usr.setCodeValueNm("사용자");
			
			ccdRepo.save(adm);
			ccdRepo.save(mng);
			ccdRepo.save(usr);
		}
		//---
		List<CmmnCodeDetail> userTyCode = ccdRepo.findByCodeId(USER_TY_CODE);
		if(userTyCode.size() == 0) {
			CmmnCodeDetail mng = new CmmnCodeDetail();
			mng.setCodeId(USER_TY_CODE);
			mng.setCodeValue(Code.USER_TY_MNG);
			mng.setCodeValueNm("관리자");
			
			CmmnCodeDetail usr = new CmmnCodeDetail();
			usr.setCodeId(USER_TY_CODE);
			usr.setCodeValue(Code.USER_TY_USR);
			usr.setCodeValueNm("고객");
			
			ccdRepo.save(mng);
			ccdRepo.save(usr);
		}
		//---
		List<CmmnCodeDetail> userSttusCode = ccdRepo.findByCodeId(USER_STTUS_CODE);
		if(userSttusCode.size() == 0) {
			CmmnCodeDetail ok = new CmmnCodeDetail();
			ok.setCodeId(USER_STTUS_CODE);
			ok.setCodeValue(Code.USER_STTUS_OK);
			ok.setCodeValueNm("정상");
			
			CmmnCodeDetail x = new CmmnCodeDetail();
			x.setCodeId(USER_STTUS_CODE);
			x.setCodeValue(Code.USER_STTUS_RESIGN);
			x.setCodeValueNm("탈퇴");
			
			ccdRepo.save(ok);
			ccdRepo.save(x);
		}
	}
}
