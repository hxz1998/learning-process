package com.mrhu.hibernate.model;

import java.util.UUID;

import javax.annotation.Generated;
import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;


@Entity
public class Husband {
	private String id;
	private String name;
	private Wife wife;

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator( 
			name = "uuid",
			strategy = "org.hibernate.id.UUIDGenerator"
			)
	public String getId() {
		return id;
	}
	//双向关联时，需要设置，这样就一边约束生成
	@OneToOne(mappedBy="husband")
	public Wife getWife() {
		return wife;
	}
	public void setWife(Wife wife) {
		this.wife = wife;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
