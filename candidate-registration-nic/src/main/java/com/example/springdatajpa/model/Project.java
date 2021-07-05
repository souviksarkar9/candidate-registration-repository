package com.example.springdatajpa.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Positive;

@Entity
public class Project implements Serializable { 
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
	
	@NotNull
	@Positive
	long candidateId;
	
	@NotNull
	String description;
	
	@NotNull
	//@Past
	Date doj;
	
	@NotNull
	//@FutureOrPresent
	Date lwd;
	
	@NotNull
	String skills;
	
	@NotNull
	String role;
	
	@NotNull
	String responsibility;
	
	@NotNull
	@Positive
	@Max(value=1000 , message="teamsize cannot be greater than 100")
	@Min(value=1 , message="teamsize cannot be less than 0")
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
