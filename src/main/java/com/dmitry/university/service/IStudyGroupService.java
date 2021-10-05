package com.dmitry.university.service;


import com.dmitry.university.model.Community.StudyGroup;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IStudyGroupService {

    Page<StudyGroup> findAll(int page, int size);

    List<StudyGroup> findAll();

    StudyGroup findById(int theId);

    void save(StudyGroup studyGroup);

    void deleteById(int theId);

}
