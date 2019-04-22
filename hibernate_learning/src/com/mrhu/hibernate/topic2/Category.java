package com.mrhu.hibernate.topic2;

import javax.persistence.*;

@Entity
@SequenceGenerator(name="categorySEQ", sequenceName="categorySEQ_DB")
public class Category {
	private int id;
	private String name;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="categorySEQ")
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
