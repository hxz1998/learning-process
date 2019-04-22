package com.mrhu.hibernate.topic;

import javax.persistence.*;

//Value object,生成报表使用

public class MsgInfo {
	private String categoryName;
	private String cont;
	private int id;
	private String topicName;
	
	public MsgInfo(int id, String cont, String topicName, String categoryName) {
		this.id = id;
		this.cont = cont;
		this.topicName = topicName;
		this.categoryName = categoryName;
	}
	
	public String getCategoryName() {
		return categoryName;
	}

	public String getCont() {
		return cont;
	}

	public int getId() {
		return id;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public void setCont(String cont) {
		this.cont = cont;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}
	
}
