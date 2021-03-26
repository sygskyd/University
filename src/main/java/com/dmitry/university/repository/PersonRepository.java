package com.dmitry.university.repository;


import com.dmitry.university.model.person.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {

}
