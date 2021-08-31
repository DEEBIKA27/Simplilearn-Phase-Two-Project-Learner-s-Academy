package com.simplilearn.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "subjects", schema ="academy")
public class Subject {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Serial No")
	private int serNo;
	
	@Column(name="Name")
	private String name;
	
	@Column(name="Shortcut")
	private String shortCut;
	
	

	public Subject() {
		super();
	}

	public Subject(int serNo, String name, String shortCut, int credit) {
		super();
		this.serNo=serNo;
		this.name = name;
		this.shortCut = shortCut;
		
	}
	
	public int getSerNo() {
		return serNo;
	}

	public void setSerNo(int serNo) {
		this.serNo = serNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortCut() {
		return shortCut;
	}

	public void setShortCut(String shortCut) {
		this.shortCut = shortCut;
	}

}
