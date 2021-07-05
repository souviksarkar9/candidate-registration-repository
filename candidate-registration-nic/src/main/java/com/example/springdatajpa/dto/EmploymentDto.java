package com.example.springdatajpa.dto;

import java.io.Serializable;
import java.util.Date;

public class EmploymentDto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	long id;
	long candidateId;
	String employers_name;
	Date doj;
	Date lwd;
	String technology;
	String designation;
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
	public String getEmployers_name() {
		return employers_name;
	}
	public void setEmployers_name(String employers_name) {
		this.employers_name = employers_name;
	}
	public Date getDoj() {
		return doj;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
	}
	public Date getLwd() {
		return lwd;
	}
	public void setLwd(Date lwd) {
		this.lwd = lwd;
	}
	public String getTechnology() {
		return technology;
	}
	public void setTechnology(String technology) {
		this.technology = technology;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}

	

}
