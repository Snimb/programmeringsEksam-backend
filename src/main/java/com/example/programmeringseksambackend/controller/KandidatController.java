package com.example.programmeringseksambackend.controller;

import com.example.programmeringseksambackend.model.Kandidat;
import com.example.programmeringseksambackend.service.KandidatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@CrossOrigin(origins = {"*"})
public class KandidatController {

    private KandidatService kandidatService;

    @Autowired
    public KandidatController(KandidatService kandidatService){
        this.kandidatService = kandidatService;
    }

    @GetMapping("/kandidat/{id}")
    public ResponseEntity<Kandidat> getKandidat(@PathVariable Integer id){
        Kandidat kandidat = kandidatService.findById(id);
        return new ResponseEntity<>(kandidat, HttpStatus.OK);
    }

    @PostMapping("/kandidat")
    public ResponseEntity<Kandidat> newCustomer(@RequestBody Kandidat kandidat)throws URISyntaxException {
        Kandidat result = null;
        result = kandidatService.saveKandidat(kandidat);
        return ResponseEntity.created(new URI("/kandidat/" + result.getKandidatID())).body(result);
    }

    @PutMapping("/kandidat/{id}")
    public ResponseEntity<Kandidat> updateKandidat(@PathVariable Integer id, @RequestBody Kandidat kandidat){
        Kandidat tmpKandidat = kandidatService.updateKandidat(kandidat, id);
        return ResponseEntity.ok().body(tmpKandidat);
    }

    @DeleteMapping("/kandidat/{id}")
    public ResponseEntity<?> deleteKandidat(@PathVariable Integer id) {
        kandidatService.deleteKandidat(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/showAllKandidater")
    public ResponseEntity<List<Kandidat>> showAllKandidater(){
        List<Kandidat> kandidater = kandidatService.findAllKandidater();
        return new ResponseEntity<>(kandidater, HttpStatus.OK);
    }
}
