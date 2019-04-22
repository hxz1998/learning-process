/**
 * 
 */
package com.mrhu.hibernate.model;

import java.io.Serializable;


/**
 * @author Mr.Hu
 *
 */
public class TeacherPK implements Serializable {
	private String name;
	private int id;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Override 
	public boolean equals(Object o) {
		if(o instanceof TeacherPK){
			TeacherPK pk = (TeacherPK)o;
			if(this.getId() == pk.getId() && this.getName().equals(pk.getName())) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return this.name.hashCode();
	}
}
