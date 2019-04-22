package com.mrhu.struts.simpledatavaliation;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport{
	
	private String name;
	
	public String add() {
		if(name == null || !name.equals("admin")){	
			this.addFieldError("name", "你的用户名是不正确的！");
			return ERROR;
		}
		return SUCCESS;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
}
