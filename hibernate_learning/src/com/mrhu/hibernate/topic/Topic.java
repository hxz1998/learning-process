package com.mrhu.hibernate.topic;

import java.util.Date;
import javax.persistence.*;

@Entity
@SequenceGenerator(name="topicSEQ", sequenceName="topicSEQ_DB")
public class Topic {
	
	private int id;
	private String title;
	private Date createDate;
	private Category category;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="topicSEQ")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
}
