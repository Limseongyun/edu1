package com.example.demo.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	
	@RequestMapping("/public/loginPage")
	public String loginPage() {
		return "pages/loginPage";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "pages/loginPage";
	}
	
	@RequestMapping("/denied")
	public String denied() {
		return "pages/loginPage";
	}

}
