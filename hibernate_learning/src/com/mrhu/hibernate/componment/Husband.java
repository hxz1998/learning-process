package com.mrhu.hibernate.componment;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;


@Entity
public class Husband {
	private int age;
	private HusbandPK pk;
	private Wife wife;
	
	@Embedded
	public Wife getWife() {
		return wife;
	}
	public void setWife(Wife wife) {
		this.wife = wife;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@EmbeddedId
	public HusbandPK getPk() {
		return pk;
	}
	public void setPk(HusbandPK pk) {
		this.pk = pk;
	}

}
