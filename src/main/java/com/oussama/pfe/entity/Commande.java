package com.oussama.pfe.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;


@Getter
@Setter
@Entity
@Table(name = "Commande")
public class Commande {

    @Id
    @GeneratedValue
    @Column(name = "id_cmd")
    private Long id;
    @Column(name = "date_cmd")
    private Date date_cmd;

    @Column(name = "etat_cmd")
    private String etat_cmd;


    public Commande() {
    }

    public Long getId() {
        return id;
    }

    public Date getDate_cmd() {
        return date_cmd;
    }

    public String getEtat_cmd() {
        return etat_cmd;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDate_cmd(Date date_cmd) {
        this.date_cmd = date_cmd;
    }

    public void setEtat_cmd(String etat_cmd) {
        this.etat_cmd = etat_cmd;
    }
}
