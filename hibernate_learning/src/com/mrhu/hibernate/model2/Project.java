package com.mrhu.hibernate.model2;

import javax.persistence.Entity;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="_Project")
public class Project {
	private int Id;
	private String proName;
	private String description;
	private String wifeName;
	private Date dateTime;
	
	
	@Temporal(TemporalType.TIME)
	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public Project(int id, String proName, String description) {
		Id = id;
		this.proName = proName;
		this.description = description;
	}
	
	
//	@Transient
	public String getWifeName() {
		return wifeName;
	}
	public void setWifeName(String wifeName) {
		this.wifeName = wifeName;
	}
	
	@Id
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	@Column(name="pppppproname")
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	
	

}
