package com.example.springdatajpa.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springdatajpa.dto.CandidateDto;
import com.example.springdatajpa.dto.EmploymentDto;
import com.example.springdatajpa.model.Candidate;
import com.example.springdatajpa.model.Employment;
import com.example.springdatajpa.repoitory.EmploymentRepository;
import com.google.common.base.Objects;

@Service
public class EmploymentService {

	private Logger logger = LoggerFactory.getLogger(EmploymentService.class);

	@Autowired
	private EmploymentRepository crepo;
	
	public List<Employment> getEmploymentbyCandidateIdId(long candidateId) {
		logger.info("Inside getEmploymentbyCandidateIdId");
		List<Employment> edulist = crepo.findAll();
		return edulist.stream().filter(ed -> Objects.equal(ed.getCandidateId(), candidateId)).collect(Collectors.toList()); 
	}

	public List<Employment> getAllEmployment() {
		logger.info("Inside getAllStudents");
		return crepo.findAll();
	}
	

	public Employment saveEmployment(Employment s) {
		logger.info("Inside Save");
		return crepo.save(s);
	}
	
	public List<Employment> convertDto2Model(List<EmploymentDto> s) {
		List<Employment> list = new ArrayList<>();
		for(EmploymentDto tmp : s) {
			list.add(convertDto2Model(tmp));		
		}
		return list;
	}
	
	public Employment convertDto2Model(EmploymentDto s) {
		Employment c = new Employment();
		c.setId(s.getId());
		c.setCandidateId(s.getCandidateId());
		c.setDesignation(s.getDesignation());
		c.setDoj(s.getDoj());
		c.setEmployers_name(s.getEmployers_name());
		c.setId(s.getId());
		c.setLwd(s.getLwd());
		c.setTechnology(s.getTechnology());
		return c;
	}
	
	public List<Employment> saveEmployment(List<Employment> s) {
		logger.info("Inside Save ALL");
		return crepo.saveAll(s);
	}

	public void deleteEmploymentResult(Long id){
		logger.info("Inside Delete");
		 crepo.deleteById(id);
	}
	
	public void deleteEmploymentCandidateIdId(long candidateId){
		logger.info("Inside Delete");
		 List<Employment> edulist = crepo.findAll().stream().filter(ed -> Objects.equal(ed.getCandidateId(), candidateId)).collect(Collectors.toList()); 
		 crepo.deleteAll(edulist);
	}

}
