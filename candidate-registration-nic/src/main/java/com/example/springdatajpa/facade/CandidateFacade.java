package com.example.springdatajpa.facade;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.example.springdatajpa.service.CandidateService;
import com.example.springdatajpa.service.EducationService;
import com.example.springdatajpa.service.EmploymentService;
import com.example.springdatajpa.service.LoginService;
import com.example.springdatajpa.service.PersonalService;
import com.example.springdatajpa.service.PhotographService;
import com.example.springdatajpa.service.ProjectService;
import com.example.springdatajpa.util.Converter;

@Component
public class CandidateFacade {

	private Logger logger = LoggerFactory.getLogger(CandidateFacade.class);

	@Autowired
	private CandidateService candidateService;

	@Autowired
	private EducationService educationService;

	@Autowired
	private EmploymentService employmentService;

	@Autowired
	private PersonalService personalService;

	@Autowired
	private PhotographService photographService;

	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private LoginService loginService;

	@Autowired
	private Converter converter;
	
	
	
	public List<EmploymentDto> saveEmployment(@Valid List<EmploymentDto> employeeDto) {
		List<EmploymentDto> list = new ArrayList<>();
		converter.convertEmploymentModel2Dto(employmentService
				.saveEmployment(employmentService.convertDto2Model(employeeDto)), list);
		return list;
	}
	
	public List<EmploymentDto> getEmployment(long candidateId) {
		List<EmploymentDto> list = new ArrayList<>();
		converter.convertEmploymentModel2Dto(employmentService.getEmploymentbyCandidateIdId(candidateId),list);
		return list;
	}
	
	public List<EducationDto>  saveEducation(@Valid List<EducationDto>  educationDto) {
		List<EducationDto> list = new ArrayList<>();
		converter.convertEducationModel2Dto(educationService.saveEducation(educationService.convertDto2Model(educationDto)), list);
		return list;
		
	}
	
	public List<EducationDto> getEducation(long candidateId) {
		List<EducationDto> list = new ArrayList<>();
		converter.convertEducationModel2Dto(educationService.getEducationbyCandidateId(candidateId),list);
		return list;
		
	}
	
	public List<PersonalDto> savePersonal(@Valid List<PersonalDto> personalDto) {
		
		List<PersonalDto> list = new ArrayList<>();
		converter.convertPersonalModel2Dto(personalService.savePersonal(personalService.convertDto2Model(personalDto)), list);
		return list;
		
	}
	
	public List<PersonalDto> getPersonal(long candidateId) {
		List<PersonalDto> list = new ArrayList<>();
		converter.convertPersonalModel2Dto(personalService.getPersonalbyCandidateId(candidateId),list);
		return list;		
	}
	
	public List<PhotographDto> savePhotograph(@Valid List<PhotographDto> photographDto) {
		
		List<PhotographDto> list = new ArrayList<>();
		converter.convertPhotographModel2Dto(photographService.savePhotograph(photographService.convertDto2Model(photographDto)), list);
		return list;
		
	}
	
	public List<PhotographDto> getPhotograph(long candidateId) {
		List<PhotographDto> list = new ArrayList<>();
		converter.convertPhotographModel2Dto(photographService.getPhotographbyCandidateId(candidateId),list);
		return list;	
		
	}
	
	public List<ProjectDto> saveProject(@Valid List<ProjectDto> projectDto) {
		
		List<ProjectDto> list = new ArrayList<>();
		converter.convertProjectModel2Dto(projectService.saveProject(projectService.convertDto2Model(projectDto)), list);
		return list;
		
	}
	
	public List<ProjectDto> getProject(long candidateId) {
		
		List<ProjectDto> list = new ArrayList<>();
		converter.convertProjectModel2Dto(projectService.getProjectbyCandidateId(candidateId),list);
		return list;	
		
	}
	
	public CandidateDto getTempLoginCredentials() {
		CandidateDto candidateDto = new CandidateDto();
		candidateDto.setPwd(loginService.getTempPassword());
		candidateDto.setUsername(loginService.getTempUserName());
		return candidateDto;
	}
	
	public List<CandidateDto> getAllCandidate() {
		List<Candidate> clist = candidateService.getAllCandidate();
		return clist.stream().map(mapper -> {
			List<CandidateDto> cdtolist = new ArrayList<>();
			List<Education> edu = educationService.getEducationbyCandidateId(mapper.getId());
			List<Employment> emp = employmentService.getEmploymentbyCandidateIdId(mapper.getId());
			List<Personal> per = personalService.getPersonalbyCandidateId(mapper.getId());
			List<Photograph> photo = photographService.getPhotographbyCandidateId(mapper.getId());
			List<Project> project = projectService.getProjectbyCandidateId(mapper.getId());
			converter.convertCandidateModels2Dto(clist, edu, emp, per, photo, project, cdtolist);
			return cdtolist;

		}).collect(Collectors.toList()).get(0);

	}

	public CandidateDto saveCandidate(@Valid CandidateDto candidateDto) {
		Candidate cand = candidateService.saveCandidate(candidateDto);
		// insert for other tables
		if (candidateDto.getEmployment() != null && !candidateDto.getEmployment().isEmpty()) {
			// saving the employee
			candidateDto.getEmployment().forEach(ce -> ce.setCandidateId(cand.getId()));
			List<Employment> emp = employmentService
					.saveEmployment(employmentService.convertDto2Model(candidateDto.getEmployment()));
			//populating saved record in candidateDto
			if(emp != null && !emp.isEmpty()) {
				emp.forEach(e -> candidateDto.getEmployment().forEach(cemp -> {
					cemp.setId(e.getId()); 
					cemp.setCandidateId(e.getCandidateId());
					cemp.setDesignation(e.getDesignation());
					cemp.setDoj(e.getDoj());
					cemp.setEmployers_name(e.getEmployers_name());
					cemp.setLwd(e.getLwd());
					cemp.setTechnology(e.getTechnology());
					cemp.setCandidateId(e.getCandidateId()); })); 
			}
		}
		if (candidateDto.getEducation() != null && !candidateDto.getEducation().isEmpty()) {
			// saving the education
			candidateDto.getEducation().forEach(ce -> ce.setCandidateId(cand.getId()));
			List<Education> edu = educationService
					.saveEducation(educationService.convertDto2Model(candidateDto.getEducation()));
			//populating saved record in candidateDto
			if(edu != null && !edu.isEmpty()) {
				edu.forEach(e -> candidateDto.getEducation().forEach(cemp -> {
					cemp.setId(e.getId()); 
					cemp.setDegree(e.getDegree());
					cemp.setDop(e.getDop());
					cemp.setGrade(e.getGrade());
					cemp.setInstitution(e.getInstitution());
					cemp.setPercentle(e.getPercentle());
					cemp.setCandidateId(e.getCandidateId()); })); 
			}
		}
		if (candidateDto.getPersonal() != null && !candidateDto.getPersonal().isEmpty()) {
			// saving the Personal
			candidateDto.getPersonal().forEach(ce -> ce.setCandidateId(cand.getId()));
			List<Personal> edu = personalService
					.savePersonal(personalService.convertDto2Model(candidateDto.getPersonal()));
			//populating saved record in candidateDto
			if(edu != null && !edu.isEmpty()) {
				edu.forEach(e -> candidateDto.getPersonal().forEach(cemp -> {
					cemp.setId(e.getId()); 
					cemp.setAddress(e.getAddress());
					cemp.setContacts(e.getContacts());
					cemp.setFatherName(e.getFatherName());
					cemp.setCandidateId(e.getCandidateId());
					; })); 					
			}
		}
		if (candidateDto.getPhotograph() != null && !candidateDto.getPhotograph().isEmpty()) {
			// saving the Photograph
			candidateDto.getPhotograph().forEach(ce -> ce.setCandidateId(cand.getId()));
			List<Photograph> edu = photographService
					.savePhotograph(photographService.convertDto2Model(candidateDto.getPhotograph()));
			//populating saved record in candidateDto
			if(edu != null && !edu.isEmpty()) {
				edu.forEach(e -> candidateDto.getPhotograph().forEach(cemp -> {
					cemp.setId(e.getId()); 
					cemp.setProfilepic(e.getProfilepic());
					cemp.setCandidateId(e.getCandidateId()); })); 
			}
		}
		if (candidateDto.getProject() != null && !candidateDto.getProject().isEmpty()) {
			// saving the Project
			candidateDto.getProject().forEach(ce -> ce.setCandidateId(cand.getId()));
			List<Project> edu = projectService
					.saveProject(projectService.convertDto2Model(candidateDto.getProject()));
			//populating saved record in candidateDto
			if(edu != null && !edu.isEmpty()) {
				edu.forEach(e -> candidateDto.getProject().forEach(cemp -> {
					cemp.setId(e.getId()); 
					cemp.setDoj(e.getDoj());
					cemp.setLwd(e.getLwd());
					cemp.setDescription(e.getDescription());
					cemp.setResponsibility(e.getResponsibility());
					cemp.setRole(e.getRole());
					cemp.setSkills(e.getSkills());
					cemp.setTeamsize(e.getTeamsize());
					cemp.setCandidateId(e.getCandidateId()); })); 
			}
		}
		//filling data in candidatedto
		candidateDto.setCandidateId(cand.getId());	
		return candidateDto;
	}

}
