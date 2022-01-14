package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import com.example.demo.mvc.model.entity3.Member;
import com.example.demo.mvc.repos.MemberRepo;

public class MyArgumetnResolver implements HandlerMethodArgumentResolver{
	//@Autowired UserRepo userRepo;
	@Autowired MemberRepo memRepo;

	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		if(parameter.getParameterType() == Member.class 
				&& SecurityContextHolder.getContext().getAuthentication() != null) {
			return true;
		}
		return false;
	}

	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		return memRepo.findById(Long.parseLong(SecurityContextHolder.getContext().getAuthentication().getName())).get();
	}

}
