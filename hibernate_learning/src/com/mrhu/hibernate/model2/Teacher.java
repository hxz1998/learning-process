package com.mrhu.hibernate.model2;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
//@SequenceGenerator(name="teacherGenerator", sequenceName="teacher_DB")
//数据库名和类名一致，所以其他不用管
public class Teacher {
//	private int Id;
//	private String name;
	private TeacherPK pk;
	private String title;
	private ZhiCheng zhiCheng;

	/**
	 * @return zhiCheng
	 */
	@Enumerated(EnumType.ORDINAL)
	public ZhiCheng getZhiCheng() {
		return zhiCheng;
	}
	/**
	 * @param zhiCheng Ҫ���õ� zhiCheng
	 */
	public void setZhiCheng(ZhiCheng zhiCheng) {
		this.zhiCheng = zhiCheng;
	}
	//注解主键
//	@Id
//	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="teacherGenerator")

	@EmbeddedId
	public TeacherPK getPk() {
		return pk;
	}
	public void setPk(TeacherPK pk) {
		this.pk = pk;
	}
	public void setTitle(String title) {
		this.title = title;
	}
//	public int getId() {
//		return Id;
//	}
//	public void setId(int id) {
//		Id = id;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
	public String getTitle() {
		return title;
	}
//	@Override
//	public String toString() {
//		return "Teacher [Id=" + Id + ", name=" + name + ", title=" + title + "]";
//	}
	
}
