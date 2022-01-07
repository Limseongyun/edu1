package com.example.demo.config.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class UseThymeleafAop {
	@Around(value = "within(@com.example.demo.config.annotation.UseThymeleaf *) || @annotation(com.example.demo.config.annotation.UseThymeleaf)")
	public Object useThymeleafAop(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		Object proceedReturnValue = proceedingJoinPoint.proceed();
		if(proceedReturnValue instanceof String) {
			proceedReturnValue = "thymeleaf/" + proceedReturnValue;
			log.debug("[@UseThymeleaf] view>>{}", proceedReturnValue);
		}
		return proceedReturnValue;
	}
}
