package com.dmitry.university.service;

import com.dmitry.university.model.Community.StudyGroup;
import com.dmitry.university.model.person.Person;
import com.dmitry.university.model.table2table.Person2Group;
import com.dmitry.university.repository.Person2GroupRepository;
import com.dmitry.university.repository.PersonRepository;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class Person2GroupService implements IPerson2GroupService{

    private Person2GroupRepository person2GroupRepository;

    public Person2GroupService(Person2GroupRepository person2GroupRepository) {
        this.person2GroupRepository = person2GroupRepository;
    }

    @Override
    public List<Person2Group> findAll() {
        return person2GroupRepository.findAll();
    }

    @Override
    public Person2Group findById(int theId) {
        return person2GroupRepository.findById(theId).orElse(null);
    }

    @Override
    public void save(Person2Group person2Group) {
        person2GroupRepository.save(person2Group);
    }

    @Override
    public void deleteById(int theId) {
        person2GroupRepository.deleteById(theId);
    }




}
