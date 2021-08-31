package com.simplilearn.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "teacher", schema ="academy")
public class Teacher {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID")
	private int id;
	
	@Column(name="First Name")
	private String firstName;
	
	@Column(name="Last Name")
	private String lastName;
	
	@Column(name="Experience in years")
	private String experience;
	
	public Teacher() {
		super();
	}
	
	public Teacher(int id, String firstName, String lastName,String experience) {
		super();
		this.id=id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.experience = experience;
	}
	
	public int getId() {
		return id;
	}

		 public void setId(int id) { 
		 this.id = id; 
	}
	 
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

}
