package com.springboot.webapplication.repository;

import com.springboot.webapplication.model.Jurusan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JurusanRepository extends JpaRepository<Jurusan, Long> {

}
