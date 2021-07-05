package com.example.springdatajpa.repoitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.springdatajpa.model.Personal;

@Repository
public interface PersonalRepository extends JpaRepository<Personal, Long>{

}
