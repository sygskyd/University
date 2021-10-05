package com.dmitry.university.service;

import com.dmitry.university.model.Community.StudyGroup;
import com.dmitry.university.model.person.Person;
import com.dmitry.university.model.table2table.Person2Group;

import java.util.List;

public interface IPerson2GroupService {
    List<Person2Group> findAll();

    Person2Group findById(int theId);

    void save(Person2Group person2Group);

    void deleteById(int theId);


}
