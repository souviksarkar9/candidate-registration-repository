package com.example.springdatajpa.repoitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.springdatajpa.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long>{

}
