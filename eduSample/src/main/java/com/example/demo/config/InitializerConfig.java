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
		//TODO: 디폴트 DB값 체크
		
		//만약 ADMIN 아이디가 없으면 만들어준다.
		User admin = userRepo.findByUserId("admin");
		log.debug("admin is {}", admin);
		if(admin == null) {
			User adm = new User();
			adm.setUserId("admin");
			adm.setUserNm("어드민");
			adm.setUserPw(pe.encode("admin"));
			userRepo.save(adm);
		}
	}
}
