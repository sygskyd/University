package com.dmitry.university.service;

import com.dmitry.university.model.person.Person;
import com.dmitry.university.repository.PersonRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PersonServiceImpl implements PersonService {

    private PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Page<Person> findAll(int page, int size) {
        return personRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public Person findById(int theId) {
        return personRepository.findById(theId).orElseThrow(() -> new IllegalArgumentException("Invalid Id:" + theId));
    }

    @Override
    public void save(Person person) {
        personRepository.save(person);
    }

    @Override
    public void deleteById(int theId) {
        personRepository.deleteById(theId);
    }


}
