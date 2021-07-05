package com.example.springdatajpa.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class CandidateDto implements Serializable {
	
	private static final long serialVersionUID = 9045425243662477255L;
	
	Long candidateId;
	String username;
	String name;
	Date dob;
	String pwd;
	List <EducationDto> education;
	List <EmploymentDto> employment;
	List <PersonalDto> personal;
	List <PhotographDto> photograph;
	List <ProjectDto> project;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Long getCandidateId() {
		return candidateId;
	}
	public void setCandidateId(Long candidateId) {
		this.candidateId = candidateId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public List<EducationDto> getEducation() {
		return education;
	}
	public void setEducation(List<EducationDto> education) {
		this.education = education;
	}
	public List<EmploymentDto> getEmployment() {
		return employment;
	}
	public void setEmployment(List<EmploymentDto> employment) {
		this.employment = employment;
	}
	public List<PersonalDto> getPersonal() {
		return personal;
	}
	public void setPersonal(List<PersonalDto> personal) {
		this.personal = personal;
	}
	public List<PhotographDto> getPhotograph() {
		return photograph;
	}
	public void setPhotograph(List<PhotographDto> photograph) {
		this.photograph = photograph;
	}
	public List<ProjectDto> getProject() {
		return project;
	}
	public void setProject(List<ProjectDto> project) {
		this.project = project;
	}
	
	
	

}
