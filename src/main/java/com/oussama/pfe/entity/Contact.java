package com.oussama.pfe.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "Contact")

public class Contact {
    @Id
    @GeneratedValue
    @Column(name = "id_contact")
    private Long id;

    @Column(name = "message")
    private String message;

    public Contact() {
    }

    public Long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
