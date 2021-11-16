package com.springboot.webapplication.service;

import com.springboot.webapplication.model.Jurusan;
import com.springboot.webapplication.model.MataKuliah;

import java.util.List;

public interface MataKuliahService {
    List<MataKuliah> getAllMataKuliah();
    void saveMataKuliah(MataKuliah mataKuliah);
    MataKuliah getMataKUliahById(long id);
    void deleteMataKuliahByID(long id);
}
