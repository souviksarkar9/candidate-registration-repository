package com.example.springdatajpa.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springdatajpa.dto.PhotographDto;
import com.example.springdatajpa.dto.ProjectDto;
import com.example.springdatajpa.model.Photograph;
import com.example.springdatajpa.model.Project;
import com.example.springdatajpa.repoitory.ProjectRepository;
import com.google.common.base.Objects;

@Service
public class ProjectService {

	private Logger logger = LoggerFactory.getLogger(ProjectService.class);

	@Autowired
	private ProjectRepository crepo;

	public List<Project> getProjectbyCandidateId(long candidateId) {
		logger.info("Inside getPersonalbyCandidateId");
		List<Project> edulist = crepo.findAll();
		return edulist.stream().filter(ed -> Objects.equal(ed.getCandidateId(), candidateId)).collect(Collectors.toList()); 
	}
	
	public List<Project> getAllProject() {
		logger.info("Inside Project");
		return crepo.findAll();
	}

	public Project saveSProject(Project s) {
		logger.info("Inside Save");
		return crepo.save(s);
	}
	
	public List<Project> saveProject(List<Project> s) {
		logger.info("Inside Save ALL");
		return crepo.saveAll(s);
	}

	public void deleteProject(Long id){
		logger.info("Inside Delete");
		 crepo.deleteById(id);
	}
	
	public void deleteProjectbyCandidateId(long candidateId){
		logger.info("Inside Delete");
		List<Project> edulist = crepo.findAll().stream().filter(ed -> Objects.equal(ed.getCandidateId(), candidateId)).collect(Collectors.toList()); 
		 crepo.deleteAll(edulist);
	}


	public List<Project> convertDto2Model(List<ProjectDto> project) {
		List<Project> list = new ArrayList<>();
		for(ProjectDto tmp : project) {
			list.add(convertDto2Model(tmp));		
		}
		return list;
	}
	
	public Project convertDto2Model(ProjectDto s) {
		Project c = new Project();
		c.setId(s.getCandidateId());
		c.setCandidateId(s.getCandidateId());
		c.setDescription(s.getDescription());
		c.setDoj(s.getDoj());
		c.setId(s.getId());
		c.setLwd(s.getLwd());
		c.setResponsibility(s.getResponsibility());
		c.setRole(s.getRole());
		c.setSkills(s.getSkills());
		c.setTeamsize(s.getTeamsize());
		
		return c;
	}

	


}
