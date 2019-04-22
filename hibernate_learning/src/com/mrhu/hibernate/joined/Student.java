package com.mrhu.hibernate.joined;

import javax.persistence.Entity;

@Entity
public class Student extends Person{
	
	private String score;

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}
}
