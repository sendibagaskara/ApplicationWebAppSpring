package com.springboot.webapplication.repository;

import com.springboot.webapplication.model.Fakultas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FakultasRepository extends JpaRepository<Fakultas, Long> {

}
