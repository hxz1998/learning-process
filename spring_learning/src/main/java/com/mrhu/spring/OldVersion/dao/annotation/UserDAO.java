package com.mrhu.spring.OldVersion.dao.annotation;

import com.mrhu.spring.OldVersion.model.annotation.User;

public interface UserDAO {

    public void save(User user);
    public void delete(User user);
    
}
