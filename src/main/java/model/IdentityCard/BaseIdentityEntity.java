package model.IdentityCard;


import lombok.Data;

import javax.persistence.*;

@Data
@MappedSuperclass
public abstract class BaseIdentityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "FirstName")
    private String firstName;

    @Column(name = "LastName")
    private String lastName;

    @Column(name = "DocumentNumber")
    private int documentNumber;
}
