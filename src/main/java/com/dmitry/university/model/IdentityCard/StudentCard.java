package com.dmitry.university.model.IdentityCard;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Data
@Entity
@Table(name = "StudentCard")
public class StudentCard extends BaseIdentityEntity {

    @Column(name = "Course")
    private String course;

    @Column(name = "GroupNumber")
    private String groupNumber;
}
