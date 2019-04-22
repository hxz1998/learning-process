package com.mrhu.hibernate.many2one;

import javax.persistence.*;

@Entity
@Table(name="t_group")
public class Group {
	
	private int id;
	private String name;
	
	
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
