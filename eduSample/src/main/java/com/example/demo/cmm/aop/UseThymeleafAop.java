package com.example.demo.cmm.aop;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class UseThymeleafAop {
	@Around(value = "within(@com.example.demo.cmm.annotations.UseThymeleaf *) || @annotation(com.example.demo.cmm.annotations.UseThymeleaf)")
			//+ "&& (within(@org.springframework.web.bind.annotation.Mapping *) || @annotation(org.springframework.web.bind.annotation.Mapping))")
	public Object useThymeleafAop(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		MethodSignature sig = (MethodSignature) proceedingJoinPoint.getSignature();
		Method method = sig.getMethod();
		Annotation[] anns = method.getAnnotations();
		
		/* XXX Annotation log TEST
		 * log.debug("anns size: {}", anns.length); for(Annotation e: anns) {
		 * log.debug("annos:{}", e); } */
		
		Object proceedReturnValue = proceedingJoinPoint.proceed();
		//returnVal이 string이고 어노테이 하나라도 있어야함.
		if(proceedReturnValue instanceof String && anns.length > 0) {
			proceedReturnValue = "thymeleaf/" + proceedReturnValue;
			log.debug("[@UseThymeleaf] view>>{}", proceedReturnValue);
		}
		return proceedReturnValue;
	}
}
