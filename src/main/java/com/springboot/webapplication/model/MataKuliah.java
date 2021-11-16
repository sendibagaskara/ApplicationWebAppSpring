package com.springboot.webapplication.model;

import javax.persistence.*;

@Entity
@Table(name = "mata_kuliah")
public class MataKuliah {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "mata_kuliah")
    private String nama_matakuliah;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNama_matakuliah() {
        return nama_matakuliah;
    }

    public void setNama_matakuliah(String nama_matakuliah) {
        this.nama_matakuliah = nama_matakuliah;
    }
}
