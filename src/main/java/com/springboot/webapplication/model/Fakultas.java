package com.springboot.webapplication.model;

import javax.persistence.*;

@Entity
@Table (name = "fakultas")
public class Fakultas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nama_fakultas")
    private String nama_fakultas;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNama_fakultas() {
        return nama_fakultas;
    }

    public void setNama_fakultas(String nama_fakultas) {
        this.nama_fakultas = nama_fakultas;
    }
}
