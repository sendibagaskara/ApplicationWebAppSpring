package com.springboot.webapplication.service;

import com.springboot.webapplication.model.Mahasiswa;

import java.util.List;

public interface MahasiswaService {
    List<Mahasiswa> getAllMahasiswa();
    void saveMahasiswa(Mahasiswa mahasiswa);
    Mahasiswa getMahasiswaById(long id);
    void deleteMahasiswaById(long id);
}
