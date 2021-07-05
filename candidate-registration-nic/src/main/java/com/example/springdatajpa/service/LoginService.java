package com.example.springdatajpa.service;

import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springdatajpa.dto.CandidateDto;
import com.example.springdatajpa.model.Candidate;

@Service
public class LoginService {

	private Logger logger = LoggerFactory.getLogger(LoginService.class);

	private Random r = new Random();

	@Autowired
	private CandidateService crepo;

	public String getTempUserName() {
		int leftLimit = 48; // numeral '0'
		int rightLimit = 122; // letter 'z'
		int targetStringLength = 10;
		return r.ints(leftLimit, rightLimit + 1).filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
				.limit(targetStringLength)
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();

	}

	public String getTempPassword() {
		return String.valueOf(Math.abs((100000 + (r.nextLong() * 899900L))));
	}
	
	public boolean updateCandidateCredentials(CandidateDto can) {

		boolean flag = false;
		try {
			if (crepo.isCandiateExist(can)) {
				crepo.saveCandidate(can);
				flag = true;
			}
		} catch (Exception e) {
			logger.info("Error:updateCandidateCredentials {}" , e.getMessage());
			return flag;
		}
		return flag;
	
		
	}

	public boolean loginCandidate(CandidateDto can) {
		boolean flag = false;
		try {
			if (crepo.isCandiateExist(can)) {
				List<Candidate> candidateList = crepo.getCandidatebyCandidateUserNameId(can);
				if (candidateList != null && !candidateList.isEmpty()) {
					flag = true;
				}
			}
		} catch (Exception e) {
			logger.info("Error:Error:updateCandidateCredentials {} " , e.getMessage());
			return flag;
		}
		return flag;
	}

}
