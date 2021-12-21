package com.example.programmeringseksambackend.repository;

import com.example.programmeringseksambackend.model.Kandidat;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Qualifier("Kandidat")
@Repository
public interface KandidatRepository extends JpaRepository<Kandidat, Integer> {
}
