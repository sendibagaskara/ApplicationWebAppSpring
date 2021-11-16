package com.springboot.webapplication.service;

import com.springboot.webapplication.model.Jurusan;
import com.springboot.webapplication.repository.JurusanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JurusanServiceImpl implements JurusanService {

    @Autowired
    private JurusanRepository jurusanRepository;

    @Override
    public List<Jurusan> getAllJurusan() {
        return jurusanRepository.findAll();
    }

    @Override
    public void saveJurusan(Jurusan jurusan) {
        this.jurusanRepository.save(jurusan);
    }

    @Override
    public Jurusan getJurusanById(long id) {
        Optional<Jurusan> optional =jurusanRepository.findById(id);
        Jurusan jurusan = null;
        if (optional.isPresent()){
            jurusan = optional.get();
        }else{
                throw new RuntimeException("Jurusan tidak ada id::" +id);
            }
            return jurusan;
    }

    @Override
    public void deleteJurusanByID(long id) {
        this.jurusanRepository.deleteById(id);
    }
}
