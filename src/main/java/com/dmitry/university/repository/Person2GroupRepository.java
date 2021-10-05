package com.dmitry.university.repository;

import com.dmitry.university.model.IdentityCard.BaseIdentityEntity;
import com.dmitry.university.model.table2table.Person2Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Person2GroupRepository extends JpaRepository<Person2Group, Integer> {

}
