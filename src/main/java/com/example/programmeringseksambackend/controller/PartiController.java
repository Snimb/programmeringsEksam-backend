package com.example.programmeringseksambackend.controller;

import com.example.programmeringseksambackend.model.Kandidat;
import com.example.programmeringseksambackend.model.Parti;
import com.example.programmeringseksambackend.service.PartiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin(origins = {"*"})
public class PartiController {

    private PartiService partiService;

    @Autowired
    public PartiController(PartiService partiService){
        this.partiService = partiService;
    }

    @GetMapping("/parti/{id}")
    public ResponseEntity<Parti> getParti(@PathVariable Integer id){
        Parti parti = partiService.findById(id);
        return new ResponseEntity<>(parti, HttpStatus.OK);
    }

    @PostMapping("/parti")
    public ResponseEntity<Parti> createParti(@RequestBody Parti parti) throws URISyntaxException{
        Parti result = null;
        result = partiService.saveParti(parti);
        return ResponseEntity.created(new URI("/parti/" + result.getPartiID())).body(result);
    }

    @PutMapping("/parti/{id}")
    public ResponseEntity<Parti> updateParti(@PathVariable Integer id, @RequestBody Parti parti){
        Parti tmpParti = partiService.updateParti(parti, id);
        return ResponseEntity.ok().body(tmpParti);
    }

    @DeleteMapping("/parti/{id}")
    public ResponseEntity<?> deleteParti(@PathVariable Integer id){
        partiService.deleteParti(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/partiKandidater/{id}")
    public ResponseEntity<Set<Kandidat>> showAllKandidater(@PathVariable Integer id){
        Set<Kandidat> kandidater = partiService.findAllKandidatsOnParti(id);
        return new ResponseEntity<>(kandidater, HttpStatus.OK);
    }

    @GetMapping("/showAllpartier")
    public ResponseEntity<List<Parti>> showAllPartier(){
        List<Parti> partier = partiService.findAllPartier();
        return new ResponseEntity<>(partier, HttpStatus.OK);
    }
}
