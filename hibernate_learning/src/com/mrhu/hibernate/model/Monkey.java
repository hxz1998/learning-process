package com.mrhu.hibernate.model;

import javax.persistence.*;

@Entity
public class Monkey {
	
	private String name;
	private String title;
	private int Id;
	private int count;
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Id
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	
}
