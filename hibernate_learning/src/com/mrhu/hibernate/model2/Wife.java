package com.mrhu.hibernate.model2;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Wife {
	private String id;
	private String name;
	private Husband husband;
	
	@Id
	@GeneratedValue
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
	@OneToOne
	@JoinColumns(
			{
				@JoinColumn(name="husbandId", referencedColumnName="id"),
				@JoinColumn(name="husbandName", referencedColumnName="name")
			}
			)
	public Husband getHusband() {
		return husband;
	}
	public void setHusband(Husband husband) {
		this.husband = husband;
	}
	
}
