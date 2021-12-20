package com.example.programmeringseksambackend.service;

import com.example.programmeringseksambackend.model.Kandidat;
import com.example.programmeringseksambackend.model.Parti;
import com.example.programmeringseksambackend.repository.PartiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.Set;

@Service
public class PartiService {

    private PartiRepository partiRepository;

    @Autowired
    public PartiService(PartiRepository partiRepository) {
        this.partiRepository = partiRepository;
    }

    public Parti findById(Integer id) {
        return partiRepository.findById(id).orElseThrow(() -> new NoResultException("Parti with id: " + id + " does not exist"));
    }

    public Parti saveParti(Parti parti) {
        return partiRepository.save(parti);
    }

    public Parti updateParti(Parti parti, Integer id) {
        Parti partiData = partiRepository.findById(id).orElseThrow(() -> new NoResultException("Parti with id: " + id + " does not exist"));
        partiData.setPartiID(parti.getPartiID());
        partiData.setPartiName(parti.getPartiName());
        return partiRepository.save(partiData);
    }

    public void deleteParti(Integer id) {
        partiRepository.deleteById(id);
    }

    public Set<Kandidat> findAllKandidatsOnParti(Integer id) {
        Parti tmpParti = partiRepository.findById(id).orElseThrow(() -> new NoResultException("Parti with id: " + id + " was not found"));
        Set<Kandidat> kandidater = tmpParti.getPartietsKandidatSet();
        return kandidater;
    }

    public List<Parti> findAllPartier(){
        return partiRepository.findAll();
    }

}