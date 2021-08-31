package com.simplilearn.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "report", schema ="academy")
public class ClassReport {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Serial No")
	private int serNo;
	
	@Column(name="Section")
	private String section;
	
	@Column(name="Student Name")
	private String studentName;
	
	@Column(name="Teacher Name")
	private String teacherName;
	
	@Column(name="Subject Name")
	private String subjectName;

	public ClassReport() {
		super();
	}

	public ClassReport(int serNo, String section, String studentName, String teacherName, String subjectName) {
		super();
		this.serNo = serNo;
		this.section = section;
		this.studentName = studentName;
		this.teacherName = teacherName;
		this.subjectName = subjectName;
	}

	public int getSerNo() {
		return serNo;
	}

	public void setSerNo(int serNo) {
		this.serNo = serNo;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

}
