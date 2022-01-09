package com.example.demo.api.restcontroller.v1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ApiSampleV1 {
	@GetMapping("/sample")
	public String sample() {
		return "sample";
	}
}
