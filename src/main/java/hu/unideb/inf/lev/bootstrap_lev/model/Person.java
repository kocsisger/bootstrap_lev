package hu.unideb.inf.lev.bootstrap_lev.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Persons")
public class Person {
    @Id
    @GeneratedValue
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private boolean enabled;
}
