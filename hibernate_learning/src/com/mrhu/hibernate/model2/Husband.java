package com.mrhu.hibernate.model2;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;


@Entity
public class Husband {
	private int age;
	private HusbandPK pk;

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
