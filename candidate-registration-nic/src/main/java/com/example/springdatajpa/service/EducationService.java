package com.example.springdatajpa.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springdatajpa.dto.EducationDto;
import com.example.springdatajpa.dto.EmploymentDto;
import com.example.springdatajpa.model.Education;
import com.example.springdatajpa.model.Employment;
import com.example.springdatajpa.repoitory.EducationRepository;
import com.google.common.base.Objects;

@Service
public class EducationService {

	private Logger logger = LoggerFactory.getLogger(EducationService.class);

	@Autowired
	private EducationRepository crepo;

	public List<Education> getEducationbyCandidateId(long candidateId) {
		logger.info("Inside getEducationbyCandidateId");
		List<Education> edulist = crepo.findAll();
		return edulist.stream().filter(ed -> Objects.equal(ed.getCandidateId(), candidateId))
				.collect(Collectors.toList());
	}

	public Education saveEducation(Education s) {
		logger.info("Inside Save");
		return crepo.save(s);
	}
	
	public List<Education> saveEducation(List<Education> s) {
		logger.info("Inside SaveALL");
		return crepo.saveAll(s);
	}

	public void deleteEducation(Long id) {
		logger.info("Inside Delete");
		crepo.deleteById(id);
	}

	public void deleteEducationbyCandidateId(long candidateId) {
		logger.info("Inside deleteEducationbyCandidateId");
		List<Education> edulist = crepo.findAll().stream().filter(ed -> Objects.equal(ed.getCandidateId(), candidateId))
				.collect(Collectors.toList());
		crepo.deleteAll(edulist);
	}

	public List<Education> convertDto2Model(List<EducationDto> education) {
		List<Education> list = new ArrayList<>();
		for(EducationDto tmp : education) {
			list.add(convertDto2Model(tmp));		
		}
		return list;
	}
	
	public Education convertDto2Model(EducationDto s) {
		Education c = new Education();
		c.setCandidateId(s.getCandidateId());
		c.setDegree(s.getDegree());
		c.setDop(s.getDop());
		c.setGrade(s.getGrade());
		c.setId(s.getId());
		c.setInstitution(s.getInstitution());
		c.setPercentle(s.getPercentle());
		return c;
	}
	

}
