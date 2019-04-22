package com.mrhu.struts.attrparaminput;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport{
	private String name;
	private int age;
	
	public String add() {
		System.out.println("Name:"+name);
		System.out.println("Age:"+age);
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
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
}
