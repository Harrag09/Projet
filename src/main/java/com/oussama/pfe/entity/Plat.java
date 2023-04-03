package com.oussama.pfe.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "Plat")
public class Plat {

    @Id
    @GeneratedValue
    @Column(name = "id_p")
    private Long id;

    @Column(name = "nom_p")
    private String nom;
    @Column(name = "prix_p")
    private float prix;

    @Column(name = "desc")
    private String desc;

    public Plat() {
    }

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public float getPrix() {
        return prix;
    }

    public String getDesc() {
        return desc;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
