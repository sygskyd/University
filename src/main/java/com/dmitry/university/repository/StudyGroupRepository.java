package com.dmitry.university.repository;

import com.dmitry.university.model.Community.StudyGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudyGroupRepository extends JpaRepository <StudyGroup, Integer> {

}
