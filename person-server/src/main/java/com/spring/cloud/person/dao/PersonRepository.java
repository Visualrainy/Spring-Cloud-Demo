package com.spring.cloud.person.dao;

import com.spring.cloud.person.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
