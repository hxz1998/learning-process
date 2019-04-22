package com.mrhu.hibernate.model;

import java.util.ArrayList;
import java.util.List;

public class Tree {
	private List<Tree> child = new ArrayList<Tree>();
	private String desc;
	private int id;
	public List<Tree> getChild() {
		return child;
	}
	public String getDesc() {
		return desc;
	}
	public int getId() {
		return id;
	}
	public void setChild(List<Tree> child) {
		this.child = child;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public void setId(int id) {
		this.id = id;
	}
}
