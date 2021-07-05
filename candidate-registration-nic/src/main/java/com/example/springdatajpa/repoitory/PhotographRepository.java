package com.example.springdatajpa.repoitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.springdatajpa.model.Photograph;

@Repository
public interface PhotographRepository extends JpaRepository<Photograph, Long>{

}
