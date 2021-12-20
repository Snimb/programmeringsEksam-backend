package com.example.programmeringseksambackend.repository;

import com.example.programmeringseksambackend.model.Parti;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Qualifier("Parti")
@Repository
public interface PartiRepository extends JpaRepository<Parti, Integer> {

}
