package com.dmitry.university.service;



import com.dmitry.university.model.person.Person;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IPersonService {

    Page<Person> findAll(int page, int size);

    List<Person> findAll();

    Person findById(int theId);

    void save(Person person);

    void deleteById(int theId);

}
