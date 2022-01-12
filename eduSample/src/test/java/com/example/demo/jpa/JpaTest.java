package com.example.demo.jpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.mvc.model.entity.User;
import com.example.demo.mvc.repos.UserRepo;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class JpaTest {

	@Autowired UserRepo userRepo;
	
	@Test
	public void test() {
		User u = new User();
		u.setUserNm("gildong");
		u.setUserPw("ha");
		
		log.debug("user is {}", u);
		userRepo.save(u);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		userRepo.save(u);
	}
}
