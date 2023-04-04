package com.oussama.pfe.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "Resto")
public class Resto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_R;
    @Column(name = "Nom_r")
    private String nom;
    @Column(name = "Address_r")
    private String Address;
    @Column(name = "email_r")
    private String email;
    @Column(name = "Password_r")
    private String Password;
    @Column(name = "Logo_R", length = 1000000)
    private byte[] logo ;


    public Resto() {
    }

    public Long getId_R() {
        return id_R;
    }

    public String getNom() {
        return nom;
    }

    public String getAddress() {
        return Address;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return Password;
    }

    public byte[] getLogo() {
        return logo;
    }

    public void setId_R(Long id_R) {
        this.id_R = id_R;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
    }
}
