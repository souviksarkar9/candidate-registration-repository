package com.example.springdatajpa.candidatecontroller;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.springdatajpa.dto.CandidateDto;
import com.example.springdatajpa.facade.CandidateFacade;

@RestController
public class CandidateController {
	
	private Logger logger  = LoggerFactory.getLogger(CandidateController.class);
	
	@Autowired
	private CandidateFacade candidateFacade;
	
	
	@RequestMapping(value="/" ,  method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> test(){
		return new ResponseEntity<>("Welcome to  Candidate Registration API", HttpStatus.OK);
	}
	
	@RequestMapping(value="/all" ,  method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_VALUE)
	//@Transactional(readOnly = true)
	//@Cacheable("candidate-cache")
	public List<CandidateDto> getAllCandidate(){
		logger.info("getAllCandidateResults: {} " , LocalDateTime.now());
		return candidateFacade.getAllCandidate();
	}
	
	@RequestMapping(value="/getCredentials" ,  method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_VALUE)
	//@Transactional(readOnly = true)
	//@Cacheable("candidate-cache")
	public CandidateDto getTempLoginDetails(){
		logger.info("getTempLoginDetails: {} " , LocalDateTime.now());
		return candidateFacade.getTempLoginCredentials();
	}
	
	@RequestMapping(value="/candidate" ,  method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_VALUE)
	//@Transactional(readOnly = true)
	//@Cacheable("candidate-cache")
	public List<CandidateDto> getCandidateById(){
		logger.info("getAllCandidateResults: {} " , LocalDateTime.now());
		return candidateFacade.getAllCandidate();
	}
	
	@RequestMapping(value="/save" ,  method = RequestMethod.POST , produces = MediaType.APPLICATION_JSON_VALUE)
	@CacheEvict("candidate-cache")
	public CandidateDto saveCandidate(@Valid @RequestBody CandidateDto candidateDto){
		logger.info("saveCandidate: {} " , LocalDateTime.now());	
		return candidateFacade.saveCandidate(candidateDto);
	}

	//Delete to be done
//	@RequestMapping(value="/delete/{id}" ,  method = RequestMethod.DELETE , produces = MediaType.APPLICATION_JSON_VALUE)
//	//@CacheEvict("candidate-cache")
//	public void deleteStudent(@Valid @RequestBody CandidateDto candidateDto){
//		candidateFacade.deleteStudentResult(id);
//	}
	

}
