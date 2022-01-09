package com.example.demo.utiltest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@SpringBootTest
public class PasswordEncodeTest {
	@Autowired PasswordEncoder pe;
	
	@Test
	public void est() {
		log.debug("as---------------------{}, {}", pe,pe.encode("asdf"));
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
