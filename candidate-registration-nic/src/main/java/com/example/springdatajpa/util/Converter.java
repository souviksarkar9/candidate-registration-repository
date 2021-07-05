package com.example.springdatajpa.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.springdatajpa.dto.CandidateDto;
import com.example.springdatajpa.dto.EducationDto;
import com.example.springdatajpa.dto.EmploymentDto;
import com.example.springdatajpa.dto.PersonalDto;
import com.example.springdatajpa.dto.PhotographDto;
import com.example.springdatajpa.dto.ProjectDto;
import com.example.springdatajpa.model.Candidate;
import com.example.springdatajpa.model.Education;
import com.example.springdatajpa.model.Employment;
import com.example.springdatajpa.model.Personal;
import com.example.springdatajpa.model.Photograph;
import com.example.springdatajpa.model.Project;
import com.sun.xml.bind.v2.model.core.Element;


@Component
public class Converter {
	
	public void convertCandidateModel2Dto(Candidate s , CandidateDto c) {
		c.setCandidateId(s.getId());
		c.setUsername(s.getUserName());
		c.setName(s.getName());
		c.setDob(s.getDob());
		c.setPwd(s.getPwd());
	}
	
	public void convertCandidateModel2Dto(List<Candidate> s , List<CandidateDto> c) {
		s.forEach(element -> {
			CandidateDto edto = new CandidateDto();
			convertCandidateModel2Dto(element , edto);
			c.add(edto);
		});
	}
	
	public void convertEducationModel2Dto(Education s , EducationDto c) {
		c.setCandidateId(s.getCandidateId());
		c.setDegree(s.getDegree());
		c.setDop(s.getDop());
		c.setGrade(s.getGrade());
		c.setId(s.getId());
		c.setInstitution(s.getInstitution());
		c.setPercentle(s.getPercentle());
	}
	
	public void convertEducationModel2Dto(List<Education> s , List<EducationDto> c) {
		s.forEach(element -> {
			EducationDto edto = new EducationDto();
			convertEducationModel2Dto(element , edto);
			c.add(edto);
		});
	}
	
	public void convertEmploymentModel2Dto(Employment s , EmploymentDto c) {
		c.setCandidateId(s.getCandidateId());
		c.setDesignation(s.getDesignation());
		c.setDoj(s.getDoj());
		c.setEmployers_name(s.getEmployers_name());
		c.setId(s.getId());
		c.setLwd(s.getLwd());
		c.setTechnology(s.getTechnology());
	}
	
	public void convertEmploymentModel2Dto(List<Employment> s , List<EmploymentDto> c) {
		s.forEach(element -> {
			EmploymentDto edto = new EmploymentDto();
			convertEmploymentModel2Dto(element , edto);
			c.add(edto);
		});
	}
	
	public void convertPersonalModel2Dto(Personal s , PersonalDto c) {
		c.setCandidateId(s.getCandidateId());
		c.setAddress(s.getAddress());
		c.setContacts(s.getContacts());
		c.setFatherName(s.getFatherName());
		c.setId(s.getId());
	}
	
	public void convertPersonalModel2Dto(List<Personal> s , List<PersonalDto> c) {
		s.forEach(element -> {
			PersonalDto edto = new PersonalDto();
			convertPersonalModel2Dto(element , edto);
			c.add(edto);
		});
	}
	
	public void convertPhotographModel2Dto(Photograph s ,PhotographDto c) {
		c.setCandidateId(s.getCandidateId());
		c.setId(s.getId());
		c.setProfilepic(s.getProfilepic());
	}
	
	public void convertPhotographModel2Dto(List<Photograph> s , List<PhotographDto> c) {
		s.forEach(element -> {
			PhotographDto edto = new PhotographDto();
			convertPhotographModel2Dto(element , edto);
			c.add(edto);
		});
	}
	
	public void convertProjectModel2Dto(Project s , ProjectDto c) {
		c.setCandidateId(s.getCandidateId());
		c.setDescription(s.getDescription());
		c.setDoj(s.getDoj());
		c.setId(s.getId());
		c.setLwd(s.getLwd());
		c.setResponsibility(s.getResponsibility());
		c.setRole(s.getResponsibility());
		c.setSkills(s.getSkills());
		c.setTeamsize(s.getTeamsize());
	}
	
	public void convertProjectModel2Dto(List<Project> s , List<ProjectDto> c) {
		s.forEach(element -> {
			ProjectDto edto = new ProjectDto();
			convertProjectModel2Dto(element , edto);
			c.add(edto);
		});
	}
	
	public void convertCandidateModels2Dto(List<Candidate> s ,List<Education> edu,List<Employment> emp,List<Personal> per,
			List<Photograph> pho,List<Project> pro, List<CandidateDto> c) {
		
		for (Candidate cand : s) {
			CandidateDto cdto = new CandidateDto();
			convertCandidateModel2Dto(cand , cdto);
			
			List<EducationDto> edudto = new ArrayList<>();
			for(Education ed : edu) {
				EducationDto edto = new EducationDto();
				convertEducationModel2Dto(ed , edto);
				edudto.add(edto);
			}
			cdto.setEducation(edudto);
			
			List<EmploymentDto> empdto = new ArrayList<>();
			for(Employment e : emp) {
				EmploymentDto edto = new EmploymentDto();
				convertEmploymentModel2Dto(e , edto);
				empdto.add(edto);
			}
			cdto.setEmployment(empdto);
			
			List<PersonalDto> personaldto = new ArrayList<>();
			for(Personal ed : per) {
				PersonalDto perdto = new PersonalDto();
				convertPersonalModel2Dto(ed , perdto);
				personaldto.add(perdto);
			}
			cdto.setPersonal(personaldto);
			
			List<PhotographDto> photodtolist = new ArrayList<>();
			for(Photograph ed : pho) {
				PhotographDto photodto = new PhotographDto();
				convertPhotographModel2Dto(ed , photodto);
				photodtolist.add(photodto);
			}
			cdto.setPhotograph(photodtolist);
			
			List<ProjectDto> projectdtolist = new ArrayList<>();
			for(Project ed : pro) {
				ProjectDto  prodto = new ProjectDto();
				convertProjectModel2Dto(ed , prodto);
				projectdtolist.add(prodto);
			}
			cdto.setProject(projectdtolist);
			
			c.add(cdto);
		}
	}

}
