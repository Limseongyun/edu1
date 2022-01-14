package com.example.demo.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.example.demo.mvc.model.entity3.Member;
import com.example.demo.mvc.repos.MemberRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MyUserDetailService implements UserDetailsService {
	//@Autowired UserRepo userRepo;
	@Autowired private MemberRepo memRepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.debug("loadByUsername: {}");
		return memRepo.findByMembId(username);
	}
}
