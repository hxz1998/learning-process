package com.mrhu.struts.introduction;

import com.opensymphony.xwork2.Action;

public class IndexAction implements Action {

	@Override
	public String execute() throws Exception {
		return "success";
	}

}
