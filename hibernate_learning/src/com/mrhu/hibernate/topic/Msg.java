package com.mrhu.hibernate.topic;

import javax.persistence.*;

@Entity
@SequenceGenerator(name="msgSEQ", sequenceName="msgSEQ_DB")
public class Msg {
	private int id;
	private String cont;
	private Topic topic;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="msgSEQ")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCont() {
		return cont;
	}
	public void setCont(String cont) {
		this.cont = cont;
	}
	@ManyToOne
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	
}
