package com.dmitry.university.model.person;


import com.dmitry.university.model.Community.StudyGroup;
import com.dmitry.university.model.IdentityCard.BaseIdentityEntity;
import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;


@Data
@ToString
@Entity
@Table(name = "PERSON")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="PERSON_ID")
    @NotNull
    int personId;

    @NotNull
    @Size(min = 1)
    @Column(name = "FIRST_NAME")
    private String firstName;

    @Size(min = 2)
    @Column(name = "LAST_NAME")
    private String lastName;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "BIRTHDATE")
    private Date birthdate;


    @ManyToOne
    @JoinColumn(name = "STUDY_GROUP_ID")
    private StudyGroup studyGroup;

    @OneToOne(optional=false, mappedBy = "person", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private BaseIdentityEntity baseIdentityEntity;

}
