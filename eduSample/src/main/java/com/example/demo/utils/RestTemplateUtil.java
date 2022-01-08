package com.example.demo.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class RestTemplateUtil {
	@Value("${baseUrl}")
	private String baseUrl;
	@Autowired
	private RestTemplate rt;
	
	public <T> T get(String url, Class<T> t){
		log.debug("a");
		return rt.getForObject(baseUrl+url, t);
	}
}
