package com.dmitry.university.model.Community;



import com.dmitry.university.model.person.Person;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;



@Getter
@Setter
@Entity
@Table(name = "STUDY_GROUP")
public class StudyGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="GROUP_ID")
    @NotNull
    private int groupId;

    @Column(name = "GROUP_NAME")
    private String groupName;

    @Column(name = "PEOPLE_COUNT")
    private int peopleCount;

    @Column(name = "COURSE_NUMBER")
    private int courseNumber;

    @OneToMany(mappedBy = "studyGroup", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Person> personList;
}
