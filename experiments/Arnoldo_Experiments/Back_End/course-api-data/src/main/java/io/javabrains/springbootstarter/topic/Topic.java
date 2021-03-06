package io.javabrains.springbootstarter.topic;

import javax.persistence.Entity;
import javax.persistence.Id;

//This creates a table in mysql database
@Entity
public class Topic {

	@Id
	private String id;
	private String name;
	private String decription;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public Topic(String id, String name, String decription) {
		super();
		this.id = id;
		this.name = name;
		this.decription = decription;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDecription() {
		return decription; 
	}
	public void setDecription(String decription) {
		this.decription = decription;
	}
}
