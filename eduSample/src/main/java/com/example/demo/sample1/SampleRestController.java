package com.example.demo.sample1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.utils.RestTemplateUtil;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class SampleRestController {
	@Autowired
	RestTemplateUtil rtu;

	@GetMapping("/test")
	public String hi() {
		log.debug("ss{}", rtu.get("/api/v1/sample", String.class));
		return "hi";
	}
}
