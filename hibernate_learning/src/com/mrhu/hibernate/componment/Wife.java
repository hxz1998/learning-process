package com.mrhu.hibernate.componment;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

public class Wife {
	private String wifeName;
	
	public String getwifeName() {
		return wifeName;
	}
	public void setwifeName(String wifeName) {
		this.wifeName = wifeName;
	}
}
