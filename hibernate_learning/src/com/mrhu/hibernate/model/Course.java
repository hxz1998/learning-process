package com.mrhu.hibernate.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.TableGenerator;

@Entity
@TableGenerator(
		name = "Course_GEN",
		table = "GENERATOR_TABLE",
		pkColumnName = "pk_key",
		valueColumnName = "pk_value",
		pkColumnValue = "Course", 
		allocationSize = 1
		)

@SequenceGenerator(name="Course_GEN", sequenceName="Course_DB")
public class Course {
	
	private String name;
	private int persons;
	
	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name 要设置的 name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return persons
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="Course_GEN")
	public int getPersons() {
		return persons;
	}
	/**
	 * @param persons 要设置的 persons
	 */
	public void setPersons(int persons) {
		this.persons = persons;
	}
	
	
}
