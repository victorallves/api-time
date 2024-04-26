package br.com.sistemas.magna.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sistemas.magna.model.Atleta;
import br.com.sistemas.magna.repository.AtletaRepository;

@RestController
@RequestMapping("/atleta")
public class AtletaController {

    @Autowired
    private AtletaRepository atletaRepository;

    @GetMapping
    public List<Atleta> getAllAtleta() {
        return atletaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Atleta> getAtletaById(@PathVariable Long id) {
        Atleta atleta = atletaRepository.findById(id)
                                  .orElse(null);
        if (atleta != null) {
            return new ResponseEntity<>(atleta, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Atleta> createAtleta(@RequestBody Atleta atleta) {
        try {
            Atleta createdAtleta = atletaRepository.save(atleta);
            return new ResponseEntity<>(createdAtleta, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Atleta> updateAtleta(@PathVariable Long id, @RequestBody Atleta atletaDetails) {
        Atleta atleta = atletaRepository.findById(id)
                                  .orElse(null);
        if (atleta != null) {
        	atleta.setCpf(atletaDetails.getCpf());
        	//faltam gets e sets
            return new ResponseEntity<>(atletaRepository.save(atleta), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Atleta> deleteAtleta(@PathVariable Long id) {
        try {
        	atletaRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

