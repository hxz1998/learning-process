package com.mrhu.struts.resultwithparam;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport{
	
	private int type;

	/**
	 * @return the type
	 */
	public int getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(int type) {
		this.type = type;
	}
	
	public String execute() {
		return SUCCESS;
	}
	
}
