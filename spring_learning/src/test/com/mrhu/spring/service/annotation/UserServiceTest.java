package com.mrhu.spring.service.annotation;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mrhu.spring.OldVersion.service.UserService;
import com.mrhu.spring.OldVersion.model.User;

public class UserServiceTest {

	@Test
	public void test() {
//		ApplicationContext application = new ClassPathXmlApplicationContext("beans_annotation.xml");
//		ApplicationContext application = new ClassPathXmlApplicationContext("beans_aop_annotation.xml");
//		ApplicationContext application = new ClassPathXmlApplicationContext("beans_aop_xml.xml");
		ApplicationContext application = new ClassPathXmlApplicationContext("beans_spring_hibernate.xml");
		UserService service = (UserService) application.getBean("userService");
		//证明是动态代理对象
		System.out.println(service.getClass());
		User u = new User();
		service.add(u);
	}
	
	//动态代理
	@Test
	public void testProxy() {
//		UserDAO userDAO = new UserDAOImpl();
//		LogInterceptor li = new LogInterceptor();
//		li.setTarget(userDAO);
//	    UserDAO userDAOProxy = (UserDAO)Proxy.newProxyInstance(userDAO.getClass().getClassLoader(), new Class[]{UserDAO.class}, li);
//	    System.out.println(userDAOProxy.getClass());
//	    userDAOProxy.save(new User());
//	    userDAOProxy.delete(new User());
	}

}
