package com.mrhu.hibernate.model;

import java.util.Date;

public class Student {
//	private int Id;
//	private String name;
	
	private StudentPK pk;
	private int age;
	private Date dateTime;
	
	public Date getDateTime() {
		return dateTime;
	}
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
//	public int getId() {
//		return Id;
//	}
//	public void setId(int id) {
//		Id = id;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public StudentPK getPk() {
		return pk;
	}
	public void setPk(StudentPK pk) {
		this.pk = pk;
	}
	
//	@Override
//	public String toString() {
//		return "Student [Id=" + Id + ", name=" + name + ", age=" + age + "]";
//	}
	
}
