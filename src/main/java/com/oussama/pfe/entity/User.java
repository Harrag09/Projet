package com.oussama.pfe.entity;

import com.oussama.pfe.UserRole;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "application_users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    //TODO: don't add no args constructor
    public User() {
    }


}