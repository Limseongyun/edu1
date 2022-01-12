package com.example.demo.mvc.restcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.mvc.model.entity.User;

import io.swagger.v3.oas.annotations.Parameter;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1")
@Slf4j
public class ApiSampleV1 {
	@GetMapping("/sample")
	public String sample(@Parameter(hidden = true)User user) {
		log.debug("loginuesr is {}", user);
		return "sample";
	}
}
