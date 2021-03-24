package com.dmitry.university.model.person;


import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
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

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "BIRTHDATE")
    private Date birthdate;

}
