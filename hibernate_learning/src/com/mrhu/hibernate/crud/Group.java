package com.mrhu.hibernate.crud;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name="t_group")
public class Group {
	
	private int id;
	private String name;
	private Set<User> users = new HashSet<User>();
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	@OneToMany(
			mappedBy = "group",
			cascade = {CascadeType.ALL},
//			fetch = FetchType.EAGER
			fetch = FetchType.LAZY
			)
	public Set<User> getUsers() {
		return users;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
}
