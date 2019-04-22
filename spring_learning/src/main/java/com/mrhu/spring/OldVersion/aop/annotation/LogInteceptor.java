package com.mrhu.spring.OldVersion.aop.annotation;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogInteceptor {

//	@Pointcut("execution(public * com.mrhu.spring.dao..*.add(..))")
	@Pointcut("execution(public * com.mrhu.spring.service..*.add(..))")
	public void myMethod(){}
	
//	@Before("execution(public void UserDAOImpl.save(User))")
//	@Before("execution(public * com.mrhu.spring.dao..*.*(..))")
	@Before("myMethod()")
	public void before() {
		System.out.println("method start");
	}
	
	@AfterReturning("execution(public * com.mrhu.spring.dao..*.*(..))")
	public void after() {
		System.out.println("method after");
	}
}
