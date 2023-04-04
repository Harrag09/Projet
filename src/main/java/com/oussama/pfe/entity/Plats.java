package com.oussama.pfe.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "Plats")
public class Plats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_p")
    private Long id_p;
    @Column(name = "nom_p")
    private String nom_p;

    @Column(name = "prix_p")
    private float prix_p;

    @Column(name = "desc_p")
    private String desc_p;

    public Plats() {
    }

    public Long getId_p() {
        return id_p;
    }

    public void setId_p(Long id_p) {
        this.id_p = id_p;
    }

    public String getNom_p() {
        return nom_p;
    }

    public void setNom_p(String nom_p) {
        this.nom_p = nom_p;
    }

    public float getPrix_p() {
        return prix_p;
    }

    public void setPrix_p(float prix_p) {
        this.prix_p = prix_p;
    }

    public String getDesc_p() {
        return desc_p;
    }

    public void setDesc_p(String desc_p) {
        this.desc_p = desc_p;
    }
}
