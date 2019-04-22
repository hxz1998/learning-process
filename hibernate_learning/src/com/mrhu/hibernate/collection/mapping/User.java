package com.mrhu.hibernate.collection.mapping;

import javax.persistence.*;

@Entity
public class User {
	
	private Group group;
	private int id;
	private String name;
	
	//fetch默认是eager
	@ManyToOne(
			cascade = {CascadeType.ALL},
//			fetch = FetchType.LAZY
			fetch = FetchType.EAGER
			)
	public Group getGroup() {
		return group;
	}
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setGroup(Group group) {
		this.group = group;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
