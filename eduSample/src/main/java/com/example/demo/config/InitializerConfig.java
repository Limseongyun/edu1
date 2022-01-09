package com.example.demo.config;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.model.entity.User;
import com.example.demo.model.repo.UserRepo;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class InitializerConfig {
	@Autowired UserRepo userRepo;
	@Autowired PasswordEncoder pe;
	
	@PostConstruct
	public void postCon() {
		log.debug("[start]");
		//TODO: ����Ʈ DB�� üũ
		
		//���� ADMIN ���̵� ������ ������ش�.
		User admin = userRepo.findByUserId("admin");
		log.debug("admin is {}", admin);
		if(admin == null) {
			User adm = new User();
			adm.setUserId("admin");
			adm.setUserNm("����");
			adm.setUserPw(pe.encode("admin"));
			userRepo.save(adm);
		}
	}
}
