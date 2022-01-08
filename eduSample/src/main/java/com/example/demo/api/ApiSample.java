package com.example.demo.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiSample {
	@GetMapping("/api/v1/sample")
	public String sample() {
		return "sample";
	}
}
