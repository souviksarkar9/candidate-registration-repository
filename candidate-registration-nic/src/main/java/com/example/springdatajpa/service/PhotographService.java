package com.example.springdatajpa.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springdatajpa.dto.PersonalDto;
import com.example.springdatajpa.dto.PhotographDto;
import com.example.springdatajpa.model.Personal;
import com.example.springdatajpa.model.Photograph;
import com.example.springdatajpa.repoitory.PhotographRepository;
import com.google.common.base.Objects;

@Service
public class PhotographService {

	private Logger logger = LoggerFactory.getLogger(PhotographService.class);

	@Autowired
	private  PhotographRepository crepo;
	
	public List<Photograph> getPhotographbyCandidateId(long candidateId) {
		logger.info("Inside getPhotographbyCandidateId");
		List<Photograph> edulist = crepo.findAll();
		return edulist.stream().filter(ed -> Objects.equal(ed.getCandidateId(), candidateId)).collect(Collectors.toList()); 
	}

	public List<Photograph> getAllPhotograph() {
		logger.info("Inside getAllPhotograph");
		return crepo.findAll();
	}

	public Photograph savePhotograph(Photograph s) {
		logger.info("Inside Save");
		return crepo.save(s);
	}
	
	public List<Photograph> savePhotograph(List<Photograph> s) {
		logger.info("Inside Save ALL");
		return crepo.saveAll(s);
	}

	public void deletePhotograph(Long id){
		logger.info("Inside Delete");
		 crepo.deleteById(id);
	}
	
	public void deletePhotograph(long candidateId){
		logger.info("Inside Delete");
		List<Photograph> edulist = crepo.findAll().stream().filter(ed -> Objects.equal(ed.getCandidateId(), candidateId)).collect(Collectors.toList()); 
		 crepo.deleteAll(edulist);
	}

	public List<Photograph> convertDto2Model(List<PhotographDto> photograph) {
		List<Photograph> list = new ArrayList<>();
		for(PhotographDto tmp : photograph) {
			list.add(convertDto2Model(tmp));		
		}
		return list;
	}
	
	public Photograph convertDto2Model(PhotographDto s) {
		Photograph c = new Photograph();
		c.setId(s.getCandidateId());
		c.setId(s.getId());
		c.setProfilepic(s.getProfilepic());
		return c;
	}

}
