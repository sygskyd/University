package com.dmitry.university.service;

import com.dmitry.university.model.paging.Paged;
import com.dmitry.university.model.person.Person;

public interface PersonService {

    Paged<Person> getPage(int pageNumber, int size);

}
