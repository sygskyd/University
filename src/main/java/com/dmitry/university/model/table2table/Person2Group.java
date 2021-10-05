package com.dmitry.university.model.table2table;


import com.dmitry.university.model.BaseEntity;
import com.dmitry.university.model.Community.StudyGroup;
import com.dmitry.university.model.person.Person;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Entity
public class Person2Group extends BaseEntity {

    @NotNull
    @Size(min = 1)
    @Column(name = "PERSON_ID")
    private Person person;

    @NotNull
    @Size(min = 1)
    @Column(name = "STUDY_GROUP_ID")
    private StudyGroup studyGroup;

}
