package com.example.demo.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.cmm.annotations.UseThymeleaf;
import com.example.demo.mvc.service.SampleService;
@Controller
public class SampleController {
	@Autowired private SampleService service;
	
	@GetMapping("/public/th1")
	@UseThymeleaf
	public String asdfsadf(Model model) {
		model.addAttribute("sample", service.sample());
		return "sample";
	}
	
	@GetMapping("/public/jsp")
	public String jsp(Model model) {
		model.addAttribute("sample", service.sample());
		return "test/haha";
	}
	
	@GetMapping("/public/sample1")
	public String smaple() {
		return "pages/samplePage";
	}
	
	@RequestMapping("/sample2")
	public String smaple2() {
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
