package com.example.demo.config;

import java.util.Optional;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import com.example.demo.cmm.code.Code;

@Configuration
public class AuditConfig implements AuditorAware<Long>{
	@Override
	public Optional<Long> getCurrentAuditor() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth == null || ! auth.isAuthenticated()) return null;
		if(Code.ANNONYMOUSE_USER.equals(auth.getPrincipal())) return null;
		String sn = String.valueOf(auth.getPrincipal());
		return Optional.of(Long.parseLong(sn));
	}
	
}
