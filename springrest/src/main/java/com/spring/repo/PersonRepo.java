package com.spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.model.Person;

public interface PersonRepo extends JpaRepository<Person, Long> {

}
