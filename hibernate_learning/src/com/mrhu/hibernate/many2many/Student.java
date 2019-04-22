package com.mrhu.hibernate.many2many;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Student {
	
	private int id;
	private String name;
	private Set<Teacher> teachers = new HashSet<Teacher>();
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	@ManyToMany(mappedBy="students")
	public Set<Teacher> getTeachers() {
		return teachers;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}
	
}
