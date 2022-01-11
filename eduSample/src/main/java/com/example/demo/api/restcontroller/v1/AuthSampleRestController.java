package com.example.demo.api.restcontroller.v1;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.api.service.AuthSampleService;
import com.example.demo.config.RVO;
import com.example.demo.model.dto.UserJoinDto;
import com.example.demo.model.entity.User;
import com.example.demo.model.repo.UserRepo;

@RestController
@Transactional
@RequestMapping("/api/v1/auth")
public class AuthSampleRestController {
	@Autowired AuthSampleService asService;
	@Autowired UserRepo userRepo;
	
	@GetMapping("/token")
	public RVO<String> getToken(@RequestParam String userId, @RequestParam String userPw) {
		return asService.getToken(userId, userPw);
	}
	
	@PostMapping("/userJoin")
	public RVO<User> userJoin(@RequestBody UserJoinDto dto) {
		return asService.userJoin(dto);
	}
	
	@PostMapping("/mngJoin")
	public RVO<User> mngJoin(@RequestBody UserJoinDto dto) {
		return asService.userJoin(dto);
	}
	
	@PostMapping("/reSign")
	public RVO<User> reSign() {
		return asService.reSign();
	}
}
