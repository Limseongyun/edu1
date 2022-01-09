package com.example.demo.config;

import java.util.Optional;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.example.demo.model.entity.User;

@Configuration
public class AuditConfig implements AuditorAware<Long>{
	@Override
	public Optional<Long> getCurrentAuditor() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth == null || ! auth.isAuthenticated()) return null;
		User user = (User)auth.getPrincipal();
		return Optional.of(user.getUserSn());
	}
	
}
