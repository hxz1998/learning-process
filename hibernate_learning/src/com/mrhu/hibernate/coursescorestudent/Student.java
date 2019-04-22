package com.mrhu.hibernate.coursescorestudent;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Student {
	private Set<Course> courses = new HashSet<Course>();
	private int id;
	private String name;
	
	@ManyToMany
	@JoinTable(
			name="score",
			joinColumns=@JoinColumn(name="student_Id"),
			inverseJoinColumns=@JoinColumn(name="course_Id")
			)
	public Set<Course> getCourses() {
		return courses;
	}
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
}
