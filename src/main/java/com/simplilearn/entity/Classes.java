package com.simplilearn.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "classes", schema ="academy")
public class Classes {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Section")
	private int section;
	
	@Column(name="Subject Name")
	private String subjectName;
	
	@Column(name="Teacher Name")
	private String teacherName;

	public Classes() {
		super();
	}

	public Classes(int section, String subjectName, String teacherName) {
		super();
		this.section = section;
		this.subjectName = subjectName;
		this.teacherName = teacherName;
	}

	public int getSection() {
		return section;
	}

	public void setSection(int section) {
		this.section = section;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
		
}
