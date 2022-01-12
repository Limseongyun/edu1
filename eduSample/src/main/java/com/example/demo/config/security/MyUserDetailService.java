package com.example.demo.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.mvc.repos.UserRepo;

@Service
public class MyUserDetailService implements UserDetailsService {
	@Autowired UserRepo userRepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userRepo.getById(Long.parseLong(username));
	}
}
