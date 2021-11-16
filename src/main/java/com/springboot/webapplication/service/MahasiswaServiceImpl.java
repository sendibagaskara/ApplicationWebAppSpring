package com.springboot.webapplication.service;

import com.springboot.webapplication.model.Mahasiswa;
import com.springboot.webapplication.repository.MahasiswaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MahasiswaServiceImpl implements MahasiswaService{

    @Autowired
    private MahasiswaRepository mahasiswaRepository;

    @Override
    public List<Mahasiswa> getAllMahasiswa() {
        return mahasiswaRepository.findAll();
    }

    @Override
    public void saveMahasiswa(Mahasiswa mahasiswa) {
        this.mahasiswaRepository.save(mahasiswa);
    }

    @Override
    public Mahasiswa getMahasiswaById(long id) {
        Optional<Mahasiswa> optional = mahasiswaRepository.findById(id);
        Mahasiswa mahasiswa = null;
        if (optional.isPresent()){
            mahasiswa = optional.get();
        }else {
            throw new RuntimeException("Mahasiswa Tidak ada Id ::" + id);
        }
        return mahasiswa;
    }

    @Override
    public void deleteMahasiswaById(long id) {
        this.mahasiswaRepository.deleteById(id);
    }
}
