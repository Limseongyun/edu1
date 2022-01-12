package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.example.demo.mvc.repos.UserRepo;

public class MyArgumetnResolver implements HandlerMethodArgumentResolver{
	@Autowired UserRepo userRepo;

	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		if(parameter.getParameterType() == UserRepo.class 
				&& SecurityContextHolder.getContext().getAuthentication() != null) {
			return true;
		}
		return false;
	}

	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		return userRepo.findById(Long.parseLong(SecurityContextHolder.getContext().getAuthentication().getName())).get();
	}

}
