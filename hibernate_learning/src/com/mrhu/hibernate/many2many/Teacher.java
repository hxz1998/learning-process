package com.mrhu.hibernate.many2many;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="t_teacher")
public class Teacher {
	
	private int id;
	private String name;
	private Set<Student> students = new HashSet<Student>();
	
	//多对多单向关联，老师知道哪些个学生被教，学生不知道哪些个老师教自己
//	@ManyToMany
//	@JoinTable(name="t_s",
//			joinColumns= {@JoinColumn(name="teacher_id")},
//			inverseJoinColumns= {@JoinColumn(name="student_idd")}
//			)
	
	//多对多双向关联
	@ManyToMany
	
	public Set<Student> getstudents() {
		return students;
	}
	public void setstudents(Set<Student> students) {
		this.students = students;
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
