package com.mrhu.struts.wildcard;

import com.opensymphony.xwork2.ActionSupport;

public class TeacherAction extends ActionSupport{
	public String add() {
		return SUCCESS;
	}
	
	public String delete() {
		return ERROR;
	}
}
