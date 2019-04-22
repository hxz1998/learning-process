package com.mrhu.spring.OldVersion.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

//提供动态代理的对象
public class LogInterceptor implements InvocationHandler{
	
	private Object target;
	
	public void beforeMethod(Method method) {
		
		System.out.println(method.getName()+" start");
		
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		beforeMethod(method);
		method.invoke(target, args);
		
		return target;
	}

	public Object getTarget() {
		return target;
	}

	public void setTarget(Object target) {
		this.target = target;
	}
	
}
