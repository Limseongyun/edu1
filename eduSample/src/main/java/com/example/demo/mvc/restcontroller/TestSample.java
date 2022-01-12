package com.example.demo.mvc.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.cmm.code.ApiCode;
import com.example.demo.cmm.utils.RVO;
import com.example.demo.mvc.model.entity.User;
import com.example.demo.mvc.repos.UserRepo;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/test")
@Slf4j
public class TestSample {
	@Autowired private UserRepo userRepo;
	
	@GetMapping("/user")
	public RVO<List<User>> users() {
		log.debug("/test");
		List<User> users = userRepo.findAll();
		return RVO.<List<User>>builder().msg("test/ userAll").code(ApiCode.NORMAL).data(users).build();
	}
	
	@GetMapping("/user/{userSn}")
	public RVO<User> userone(@PathVariable String userSn) {
		User user = userRepo.findById(Long.parseLong(userSn)).get();
		return RVO.<User>builder().msg("test/ userone").code(ApiCode.NORMAL).data(user).build();
	}

}
