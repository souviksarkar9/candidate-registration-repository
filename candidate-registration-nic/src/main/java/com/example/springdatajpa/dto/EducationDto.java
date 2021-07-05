package com.example.springdatajpa.dto;

import java.io.Serializable;
import java.util.Date;

public class EducationDto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2345420422787210801L;
	long id;
	long candidateId;
	String degree;
	Date dop;
	String institution;
	String grade;
	Long percentle;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getCandidateId() {
		return candidateId;
	}
	public void setCandidateId(long candidateId) {
		this.candidateId = candidateId;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public Date getDop() {
		return dop;
	}
	public void setDop(Date dop) {
		this.dop = dop;
	}
	public String getInstitution() {
		return institution;
	}
	public void setInstitution(String institution) {
		this.institution = institution;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public Long getPercentle() {
		return percentle;
	}
	public void setPercentle(Long percentle) {
		this.percentle = percentle;
	}
	
	

}
