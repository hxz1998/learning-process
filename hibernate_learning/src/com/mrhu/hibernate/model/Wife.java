package com.mrhu.hibernate.model;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Wife {
	private String id;
	private String name;
	private Husband husband;
	
	@Id
	//生成ID
	@GeneratedValue(generator = "uuid")
	@GenericGenerator( 
			name = "uuid",
			strategy = "org.hibernate.id.UUIDGenerator"
			)
	
	public String getId() {
		return id;
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
	
	//一对一外键关联
//	@OneToOne
	@JoinColumn(name="husbandId")
	//一对一主键关联
	@PrimaryKeyJoinColumn
	@ManyToOne
	public Husband getHusband() {
		return husband;
	}
	public void setHusband(Husband husband) {
		this.husband = husband;
	}
	
}
