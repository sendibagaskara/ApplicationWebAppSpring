package com.springboot.webapplication.service;

import com.springboot.webapplication.model.Fakultas;
import com.springboot.webapplication.repository.FakultasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FakultasServiceImpl implements FakultasService{

    @Autowired
    private FakultasRepository fakultasRepository;

    @Override
    public List<Fakultas> getAllFakultas() {
        return fakultasRepository.findAll();
    }

    @Override
    public void saveFakultas(Fakultas fakultas) {

        this.fakultasRepository.save(fakultas);

    }

    @Override
    public Fakultas getFakultasById(long id) {
        Optional<Fakultas> optional = fakultasRepository.findById(id);
        Fakultas fakultas = null;
        if (optional.isPresent()){
            fakultas = optional.get();
        }else {
            throw new RuntimeException("Fakultas tidak ada Id::"+id);
        }
        return fakultas;
    }

    @Override
    public void deleteFakultasByID(long id) {
        this.fakultasRepository.deleteById(id);
    }

}
