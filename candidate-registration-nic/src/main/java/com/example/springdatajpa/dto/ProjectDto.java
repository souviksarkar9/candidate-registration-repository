package com.example.springdatajpa.dto;

import java.io.Serializable;
import java.util.Date;

public class ProjectDto implements Serializable { 
	private static final long serialVersionUID = 1L;
	
	long id;
	long candidateId;
	String description;
	Date doj;
	Date lwd;
	String skills;
	String role;
	String responsibility;
	Long teamsize;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getResponsibility() {
		return responsibility;
	}
	public void setResponsibility(String responsibility) {
		this.responsibility = responsibility;
	}
	public Long getTeamsize() {
		return teamsize;
	}
	public void setTeamsize(Long teamsize) {
		this.teamsize = teamsize;
	}
	
	

}
