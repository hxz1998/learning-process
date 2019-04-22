package com.mrhu.struts.attrparaminput;

import com.mrhu.struts.model.User;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction2 extends ActionSupport{
	private User user;
	
	public String add() {
		System.out.println(user.getAge());
		System.out.println(user.getName());
		return SUCCESS;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
	
}
