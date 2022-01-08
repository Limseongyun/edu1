package com.example.demo.sample1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.config.annotation.UseThymeleaf;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class SampleController {
	@GetMapping("/sample1")
	public String smaple() {
		return "pages/samplePage";
	}
	
	@RequestMapping("/sample2")
	public String smaple2() {
		int a = 1/0;
		return "test/haha";
	}
	
	@RequestMapping("/sample3")
	public String smaple3() {
		return "test/hah2a";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "pages/loginPage";
	}
	
	@RequestMapping("/register")
	public String register() {
		return "pages/registerPage";
	}
}
