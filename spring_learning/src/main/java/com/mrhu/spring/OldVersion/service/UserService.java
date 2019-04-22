package com.mrhu.spring.OldVersion.service;

import com.mrhu.spring.OldVersion.dao.LogDAO;
import com.mrhu.spring.OldVersion.dao.UserDAO;
import com.mrhu.spring.OldVersion.model.Log;
import com.mrhu.spring.OldVersion.model.User;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;


@Component("userService")
public class UserService {

    private UserDAO userDAO;
    private LogDAO logDAO;

    public UserService() {}

    public LogDAO getLogDAO() {
        return logDAO;
    }

    @Resource(name = "logDAO")
    public void setLogDAO(LogDAO logDAO) {
        this.logDAO = logDAO;
    }

    public UserService(UserDAO userDAO) {
    	this.userDAO = userDAO;
    }

    @Transactional
    public void add(User user) {
        this.userDAO.save(user);
        Log log = new Log();
        log.setMsg("a user saved");
        logDAO.save(log);
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }
    
    //Autowire要和Qualifier混合着用，Qualifier传入的值是bean的name
//    @Autowired
//    public void setUserDAO(@Qualifier(value="u") UserDAO userDAO) {
    
    //和component一起用
    @Resource(name="userDAO")
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
    
    @PostConstruct
    public void init() {
    	System.out.println("init");
    }
    @PreDestroy
    public void destory() {
    	System.out.println("destory");
    }
}
