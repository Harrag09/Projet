package com.oussama.pfe.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "Ligne_Commande")
public class Ligne_Commande {

    @Column(name = "Qte_cmd")
    private int Qte_cmd;
}
