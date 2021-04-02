package com.dmitry.university.model.Community;


import com.dmitry.university.model.IdentityCard.BaseIdentityEntity;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
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
    private Set<BaseIdentityEntity> peopleIdSet;
}
