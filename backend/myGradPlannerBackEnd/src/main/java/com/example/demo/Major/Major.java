package com.example.demo.Major;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Major {

	@Id
	private String id;

	private String majorName;
	private String majorDescription;

	public String getId() {
		return id;
	}

	public Major setId(String id) {
		this.id = id;
		return this;
	}

	public String getMajorName() {
		return majorName;
	}

	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}

	public Major(String id, String majorName, String majorDescription) {
		super();
		this.id = id;
		this.majorName = majorName;
		this.majorDescription = majorDescription;
	}

	public Major() {
		super();
	}

	public String getMajorDescription() {
		return majorDescription;
	}

	public void setMajorDescription(String majorDescription) {
		this.majorDescription = majorDescription;
	}

}