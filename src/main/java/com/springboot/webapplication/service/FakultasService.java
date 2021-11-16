package com.springboot.webapplication.service;

import com.springboot.webapplication.model.Fakultas;

import java.util.List;

public interface FakultasService {
   List<Fakultas> getAllFakultas();
   void saveFakultas(Fakultas fakultas);
   Fakultas getFakultasById(long id);
   void deleteFakultasByID(long id);
}
