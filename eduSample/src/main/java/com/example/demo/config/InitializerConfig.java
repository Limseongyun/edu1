package com.example.demo.config;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class InitializerConfig {
	@PostConstruct
	public void postCon() {
		log.debug("[start]");
		//TODO: 디폴트 DB값 체크
	}
}
