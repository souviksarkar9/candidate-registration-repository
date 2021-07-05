package com.example.springdatajpa.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springdatajpa.dto.EmploymentDto;
import com.example.springdatajpa.dto.PersonalDto;
import com.example.springdatajpa.model.Employment;
import com.example.springdatajpa.model.Personal;
import com.example.springdatajpa.repoitory.PersonalRepository;
import com.google.common.base.Objects;

@Service
public class PersonalService {

	private Logger logger = LoggerFactory.getLogger(PersonalService.class);

	@Autowired
	private PersonalRepository crepo;
	
	public List<Personal> getPersonalbyCandidateId(long candidateId) {
		logger.info("Inside getPersonalbyCandidateId");
		List<Personal> edulist = crepo.findAll();
		return edulist.stream().filter(ed -> Objects.equal(ed.getCandidateId(), candidateId)).collect(Collectors.toList()); 
	}

	public List<Personal> getAllPersonal() {
		logger.info("Inside getAllPersonal");
		return crepo.findAll();
	}

	public Personal savePersonal(Personal s) {
		logger.info("Inside Save");
		return crepo.save(s);
	}
	
	public List<Personal> savePersonal(List<Personal> s) {
		logger.info("Inside Save ALL");
		return crepo.saveAll(s);
	}

	public void deletePersonal(Long id){
		logger.info("Inside Delete");
		 crepo.deleteById(id);
	}
	
	public void deletePersonalbyCandidateId(long candidateId){
		logger.info("Inside Delete");
		List<Personal> edulist = crepo.findAll().stream().filter(ed -> Objects.equal(ed.getCandidateId(), candidateId)).collect(Collectors.toList()); 
		 crepo.deleteAll(edulist);
	}

	public List<Personal> convertDto2Model(List<PersonalDto> personal) {
		List<Personal> list = new ArrayList<>();
		for(PersonalDto tmp : personal) {
			list.add(convertDto2Model(tmp));		
		}
		return list;
	}
	public Personal convertDto2Model(PersonalDto s) {
		Personal c = new Personal();
		c.setId(s.getCandidateId());
		c.setAddress(s.getAddress());
		c.setCandidateId(s.getCandidateId());
		c.setContacts(s.getContacts());
		c.setFatherName(s.getFatherName());
		c.setId(s.getId());
		return c;
	}
	

}
