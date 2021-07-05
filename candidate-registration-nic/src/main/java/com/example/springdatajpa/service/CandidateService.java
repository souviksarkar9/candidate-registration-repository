package com.example.springdatajpa.service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springdatajpa.dto.CandidateDto;
import com.example.springdatajpa.model.Candidate;
import com.example.springdatajpa.repoitory.CadidateRepository;
import com.google.common.base.Objects;

@Service
public class CandidateService {

	private Logger logger = LoggerFactory.getLogger(CandidateService.class);

	@Autowired
	private CadidateRepository crepo;
	
	
	public boolean isUserNameExist(CandidateDto candidate) {
		try {
			List<Candidate> clist = crepo.findAll().stream().filter(ed -> Objects.equal(ed.getUserName(), candidate.getUsername())).collect(Collectors.toList());
			if(clist != null && !clist.isEmpty()) {
				return true;
			}
		}catch(Exception e) {
			logger.info("Exception : isUserNameExist " + e.getMessage());
			return false;
		}
		return false;
	}
	
	
	public boolean isCandiateExist(CandidateDto candidate) {
		try {
			List<Candidate> clist = crepo.findAll().stream().filter(ed -> Objects.equal(ed.getUserName(), candidate.getUsername()) &&  Objects.equal(ed.getPwd(), candidate.getPwd()) )
					.collect(Collectors.toList());
			if(clist != null && !clist.isEmpty()) {
				return true;
			}
		}catch(Exception e) {
			logger.info("Exception : isCandiateExist " + e.getMessage());
			return false;
		}
		return false;
	}

	public List<Candidate> getCandidatebyCandidateUserNameId(CandidateDto candidate) {
		logger.info("Inside getCandidatebyCandidateUserNameId");
		List<Candidate> clist = crepo.findAll();
		return clist.stream().filter(ed -> Objects.equal(ed.getUserName(), candidate.getUsername()) || Objects.equal(ed.getId(), candidate.getCandidateId())).collect(Collectors.toList());
	}

	public List<Candidate> getAllCandidate() {
		logger.info("Inside getAllCandidate");
		return crepo.findAll();
	}

	public Candidate saveCandidate(CandidateDto s) {
		logger.info("Inside Save");
		return crepo.save(convertDto2Model(s));
	}
	
	
	
	public Candidate convertDto2Model(CandidateDto s) {
		Candidate c = new Candidate();
		c.setId(s.getCandidateId());
		c.setUserName(s.getUsername());
		c.setName(s.getName());
		c.setDob(s.getDob());
		c.setPwd(s.getPwd());
		return c;
	}
	


	public void deleteCandidate(CandidateDto s) {
		logger.info("Inside Delete");
		for (Candidate c : getCandidatebyCandidateUserNameId(s)) {
			crepo.deleteById(c.getId());
		}		
	}

	public void deleteCandidatebyCandidateUserNameId(CandidateDto s) {
		logger.info("Inside Delete");
		List<Candidate> clist = crepo.findAll();
		crepo.deleteAll(clist.stream().filter(ed -> Objects.equal(ed.getUserName(), s.getUsername()) || Objects.equal(ed.getId(), s.getCandidateId())).collect(Collectors.toList()));
	}

}
