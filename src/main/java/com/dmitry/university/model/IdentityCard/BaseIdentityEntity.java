package com.dmitry.university.model.IdentityCard;


import com.dmitry.university.model.BaseEntity;
import com.dmitry.university.model.Community.StudyGroup;
import com.dmitry.university.model.person.Person;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.*;


@Getter
@Setter
@Entity
@Table(name = "BASE_ID_ENTITY")
public class BaseIdentityEntity extends BaseEntity {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name="CARD_ID")
//    @NotNull
//    private int cardId;

    @NotNull
    @Size(min = 1)
    @Column(name = "FIRST_NAME")
    private String firstName;

    @Size(min = 2)
    @Column(name = "LAST_NAME")
    private String lastName;


    @Min(value = 100000)
    @Max(value = 999999)
    //@Pattern(regexp = "\\[0-9]{6}", message = "must be 6 digits")
    @Column(name = "DOC_NUMBER")
    private int documentNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "ID_CARD_TYPE")
    private IdCardType idCardType;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PERSON_ID")
    private Person person;

}
