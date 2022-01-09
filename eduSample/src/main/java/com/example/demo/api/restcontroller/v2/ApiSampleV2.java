package com.example.demo.api.restcontroller.v2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2")
public class ApiSampleV2 {
	@GetMapping("/sample")
	public String sample2() {
		return "sample";
	}
}
