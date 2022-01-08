package com.example.demo.sample1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleRestController {

	@GetMapping("/test")
	public String hi() {
		return "hi";
	}
}
