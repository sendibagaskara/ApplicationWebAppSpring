package com.springboot.webapplication.service;

import com.springboot.webapplication.model.Fakultas;
import com.springboot.webapplication.model.Jurusan;

import java.util.List;

public interface JurusanService {
    List<Jurusan> getAllJurusan();
    void saveJurusan(Jurusan jurusan);
    Jurusan getJurusanById(long id);
    void deleteJurusanByID(long id);
}
