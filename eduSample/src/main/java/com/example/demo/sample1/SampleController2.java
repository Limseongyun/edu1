package com.example.demo.sample1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.config.annotation.UseThymeleaf;

@Controller
@UseThymeleaf
public class SampleController2 {

	@GetMapping("/th1")
	public String asdfsadf() {
		return "sample";
	}
}
