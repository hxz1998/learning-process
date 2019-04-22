package com.mrhu.hibernate.collection.mapping;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name="t_group")
public class Group {
	
	private int id;
	private String name;
/*	private List<User> users = new ArrayList<User>();
	@OneToMany(
			mappedBy = "group",
			cascade = {CascadeType.ALL},
//			fetch = FetchType.EAGER
			fetch = FetchType.LAZY
			)
	@OrderBy("name ASC")
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	*/
	
	private Map<Integer, User> users = new HashMap<Integer, User>();
	
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
	@MapKey(name="id")
	public Map<Integer, User> getUsers() {
		return users;
	}
	public void setUsers(Map<Integer, User> users) {
		this.users = users;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
}
