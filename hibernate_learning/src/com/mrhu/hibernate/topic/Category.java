package com.mrhu.hibernate.topic;

import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@SequenceGenerator(name="categorySEQ", sequenceName="categorySEQ_DB")
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
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
