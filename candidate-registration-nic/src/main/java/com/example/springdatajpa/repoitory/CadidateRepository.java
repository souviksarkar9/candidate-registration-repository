package com.example.springdatajpa.repoitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.springdatajpa.model.Candidate;

@Repository
public interface CadidateRepository extends JpaRepository<Candidate, Long>{

}
