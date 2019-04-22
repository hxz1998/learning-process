package com.mrhu.spring.OldVersion.aop._xml;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

public class LogInteceptor {

	public void before() {
		System.out.println("method start");
	}
	
	public void after() {
		System.out.println("method after");
	}
}
