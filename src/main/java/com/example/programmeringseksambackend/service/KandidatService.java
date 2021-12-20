package com.example.programmeringseksambackend.service;

import com.example.programmeringseksambackend.model.Kandidat;
import com.example.programmeringseksambackend.model.Parti;
import com.example.programmeringseksambackend.repository.KandidatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.List;

@Service
public class KandidatService {

    private KandidatRepository kandidatRepository;

    @Autowired
    public KandidatService(KandidatRepository kandidatRepository){
        this.kandidatRepository = kandidatRepository;
    }

    public Kandidat findById(Integer id){
        return kandidatRepository.findById(id).orElseThrow(() -> new NoResultException("Kandidat with id: "+ id + " does not exist"));
    }

    public List<Kandidat> findAllKandidater(){
        return kandidatRepository.findAll();
    }

    public Kandidat saveKandidat(Kandidat kandidat){
        return kandidatRepository.save(kandidat);
    }

    public Kandidat updateKandidat(Kandidat kandidat, Integer id) {
        Kandidat kandidatData = kandidatRepository.findById(id).orElseThrow(() -> new NoResultException("Kandidat with id: " + id + " does not exist"));
        kandidatData.setKandidatID(kandidat.getKandidatID());
        kandidatData.setKandidatName(kandidat.getKandidatName());
        return kandidatRepository.save(kandidatData);
    }

    public void deleteKandidat(Integer id){
        kandidatRepository.deleteById(id);
    }

}
