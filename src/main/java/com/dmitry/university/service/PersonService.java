package com.dmitry.university.service;


import com.dmitry.university.model.IdentityCard.BaseIdentityEntity;
import com.dmitry.university.model.person.Person;
import org.springframework.data.domain.Page;

public interface PersonService {

    Page<Person> findAll(int page, int size);

    Person findById(int theId);

    void save(Person person);

    void deleteById(int theId);

}
