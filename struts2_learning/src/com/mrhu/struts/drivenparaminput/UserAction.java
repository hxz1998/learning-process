package com.mrhu.struts.drivenparaminput;

import com.mrhu.struts.model.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<User>{

	private User user = new User();
	
	public String add() {
		System.out.println("User:"+user.getName());
		System.out.println("User:"+user.getAge());
		return SUCCESS;
	}
	
	@Override
	public User getModel() {
		return user;
	}

}
