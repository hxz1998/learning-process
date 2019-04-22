package com.mrhu.spring.dao;

import com.mrhu.spring.OldVersion.service.onetoseven.UserService;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/** 
* UserService Tester. 
* 
* @author <Authors name> 
* @since <pre>02/13/2018</pre> 
* @version 1.0 
*/ 
public class UserServiceTest { 

    @Test
    public void testAdd() throws Exception {
    	ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans_onetoseven.xml");
    	
//    	UserService service = (UserService) applicationContext.getBean("userService");
//    	UserService service2 = (UserService) applicationContext.getBean("userService");
//    	System.out.println(service == service2);
//        User user = new User();
//        service.add(user);
    	
//    	UserDAO dao = (UserDAO) applicationContext.getBean("moreComplexObject");
//    	System.out.println(dao);

    	UserService service = (UserService) applicationContext.getBean("userServiceAutowire");
    	System.out.println(service.getUserDAO());
    }
}
