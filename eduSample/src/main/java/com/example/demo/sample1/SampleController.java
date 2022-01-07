package com.example.demo.sample1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.config.annotation.UseThymeleaf;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class SampleController {

	@GetMapping("/sample1")
	public String smaple() {
		log.debug("hi");
		return "sample";
	}
	@GetMapping("/sample2")
	@UseThymeleaf
	public String smaple2() {
		return "sample";
	}
}
