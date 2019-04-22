package com.mrhu.hibernate.many2one;

import javax.persistence.*;

@Entity
public class User {
	
	private int id;
	private String name;
	private Group group;
	
	@ManyToOne
	public Group getGroup() {
		return group;
	}
	public void setGroup(Group group) {
		this.group = group;
	}
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
