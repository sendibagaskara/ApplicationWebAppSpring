package com.springboot.webapplication.service;

import com.springboot.webapplication.model.MataKuliah;
import com.springboot.webapplication.repository.MataKuliahRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MataKuliahServiceImpl implements MataKuliahService{

    @Autowired
    private MataKuliahRepository mataKuliahRepository;

    @Override
    public List<MataKuliah> getAllMataKuliah() {
        return mataKuliahRepository.findAll();
    }

    @Override
    public void saveMataKuliah(MataKuliah mataKuliah) {
        this.mataKuliahRepository.save(mataKuliah);
    }

    @Override
    public MataKuliah getMataKUliahById(long id) {
        Optional<MataKuliah> optional = mataKuliahRepository.findById(id);
        MataKuliah mataKuliah = null;
        if(optional.isPresent()){
            mataKuliah = optional.get();
        }else {
            throw new RuntimeException("Mata Kuliah TIdak Ada ::" +id);
        }
        return mataKuliah;
    }

    @Override
    public void deleteMataKuliahByID(long id) {
        this.mataKuliahRepository.deleteById(id);
    }
}
