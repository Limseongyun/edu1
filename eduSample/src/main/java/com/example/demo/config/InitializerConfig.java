package com.example.demo.config;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

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
			userRepo.save(adm);
		}
		
		List<CmmnCodeDetail> roleTyCode = ccdRepo.findByCodeId(ROLE_TY_CODE);
		if(roleTyCode.size() == 0) {
			log.debug("cmmncode insert!");
			CmmnCodeDetail adm = new CmmnCodeDetail();
			adm.setCodeId(ROLE_TY_CODE);
			adm.setCodeValue("01");
			adm.setCodeValueNm("어드민");
			
			CmmnCodeDetail mng = new CmmnCodeDetail();
			mng.setCodeId(ROLE_TY_CODE);
			mng.setCodeValue("02");
			mng.setCodeValueNm("관리자");
			
			CmmnCodeDetail usr = new CmmnCodeDetail();
			usr.setCodeId(ROLE_TY_CODE);
			usr.setCodeValue("03");
			usr.setCodeValueNm("사용자");
			
			ccdRepo.save(adm);
			ccdRepo.save(mng);
			ccdRepo.save(usr);
		}
	}
}
