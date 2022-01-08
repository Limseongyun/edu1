package com.example.demo.sample1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.config.annotation.UseThymeleaf;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class SampleController {
	@UseThymeleaf
	@GetMapping("/sample1")
	public String smaple() {
		return "sample";
	}
	
	@RequestMapping("/sample2")
	public String smaple2() {
		return "sample";
	}
}
