package com.mrhu.hibernate.coursescorestudent;

import javax.persistence.*;

@Entity
@Table(name="score")
public class Score {
	private Course course;
	private int id;
	private int score;
	private Student student;
	
	@ManyToOne
	@JoinColumn(name="course_Id")
	public Course getCourse() {
		return course;
	}
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public int getScore() {
		return score;
	}
	@ManyToOne
	@JoinColumn(name="student_Id")
	public Student getStudent() {
		return student;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
}
