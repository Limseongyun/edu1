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
		//TODO: ����Ʈ DB�� üũ
		
		//���� ADMIN ���̵� ������ ������ش�.
		User admin = userRepo.findByUserId("admin");
		if(admin == null) {
			log.debug("admin insert!");
			User adm = new User();
			adm.setUserId("admin");
			adm.setUserNm("����");
			adm.setUserPw(pe.encode("admin"));
			userRepo.save(adm);
		}
		
		List<CmmnCodeDetail> roleTyCode = ccdRepo.findByCodeId(ROLE_TY_CODE);
		if(roleTyCode.size() == 0) {
			log.debug("cmmncode insert!");
			CmmnCodeDetail adm = new CmmnCodeDetail();
			adm.setCodeId(ROLE_TY_CODE);
			adm.setCodeValue("01");
			adm.setCodeValueNm("����");
			
			CmmnCodeDetail mng = new CmmnCodeDetail();
			mng.setCodeId(ROLE_TY_CODE);
			mng.setCodeValue("02");
			mng.setCodeValueNm("������");
			
			CmmnCodeDetail usr = new CmmnCodeDetail();
			usr.setCodeId(ROLE_TY_CODE);
			usr.setCodeValue("03");
			usr.setCodeValueNm("�����");
			
			ccdRepo.save(adm);
			ccdRepo.save(mng);
			ccdRepo.save(usr);
		}
	}
}
