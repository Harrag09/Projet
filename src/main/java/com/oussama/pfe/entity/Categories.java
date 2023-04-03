package com.oussama.pfe.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "Categories")
public class Categories {
    @Id
    @GeneratedValue
    @Column(name = "id_c")
    private Long id_C;
    @Column(name = "img", length = 1000)
    private byte[] img ;

    public Categories() {
    }

    public Long getId_C() {
        return id_C;
    }

    public byte[] getImg() {
        return img;
    }

    public void setId_C(Long id_C) {
        this.id_C = id_C;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }
}
