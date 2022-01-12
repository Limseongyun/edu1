package com.example.demo.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.cmm.annotations.UseThymeleaf;
@Controller
public class SampleController {
	@GetMapping("/public/th1")
	@UseThymeleaf
	public String asdfsadf() {
		return "sample";
	}
	
	@GetMapping("/public/jsp")
	public String jsp() {
		return "test/haha";
	}
	
	@GetMapping("/public/sample1")
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
	
	@GetMapping("/public/index")
	public String index() {
		return "pages/indexPage";
	}
}
