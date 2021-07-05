package com.example.springdatajpa.repoitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.springdatajpa.model.Education;

@Repository
public interface EducationRepository extends JpaRepository<Education, Long>{

}
