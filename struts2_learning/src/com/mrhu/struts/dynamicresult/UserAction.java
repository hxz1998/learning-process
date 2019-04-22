package com.mrhu.struts.dynamicresult;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	
	private String r;
	private int type;
	
	
	
	/**
	 * @return the r
	 */
	public String getR() {
		return r;
	}



	/**
	 * @param r the r to set
	 */
	public void setR(String r) {
		this.r = r;
	}



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



	@Override
	public String execute() {
		if(type == 1) {
			r = "/Studentadd_success.jsp";
		}else if(type == 2){
			r = "/Teacherdelete_error.jsp";
		}
		return SUCCESS;
	}
	
}
