package com.mrhu.spring.OldVersion.aop._xml;

import com.mrhu.spring.OldVersion.dao.annotation.UserDAO;
import com.mrhu.spring.OldVersion.model.annotation.User;

public class UserService {

    private com.mrhu.spring.OldVersion.dao.annotation.UserDAO userDAO;

    public UserService() {}
    
    public UserService(com.mrhu.spring.OldVersion.dao.annotation.UserDAO userDAO) {
    	this.userDAO = userDAO;
    }

    public void add(User user) {
        this.userDAO.save(user);
    }

    public com.mrhu.spring.OldVersion.dao.annotation.UserDAO getUserDAO() {
        return userDAO;
    }
    
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
    
    public void init() {
    	System.out.println("init");
    }
    public void destory() {
    	System.out.println("destory");
    }
}
