package com.example.demo.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired private JwtUnAuthenticationEntryPoint unauthorizaedHadle;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/webjars/**", "/files/**", "/swagger-ui/**");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable()
			.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
			.exceptionHandling()
				.authenticationEntryPoint(unauthorizaedHadle)
				.and()
			.authorizeRequests()
				.antMatchers("/swagger-ui/**", "/v3/api-docs/**",//Swagger ���
							 "/api/*/auth/**", //auth�� �����ϸ� ���
							 "/public/**").permitAll() //public ���� �����ϸ� ���, ȭ���
				.antMatchers("/**").authenticated()
				.and()
			.addFilterBefore(new JwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
			.formLogin().disable().headers().frameOptions().disable();
	}
}
