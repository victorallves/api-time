package br.com.sistemas.magna.controller;

import java.util.List;
import java.util.Optional;

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

import br.com.sistemas.magna.dto.TecnicoDTO;
import br.com.sistemas.magna.service.TecnicoService;

@RestController
@RequestMapping("/tecnicos")
public class TecnicoController {

    @Autowired
    private TecnicoService tecnicoService;

    @GetMapping
    public List<TecnicoDTO> getAllTecnicos() {
        return tecnicoService.getAllTecnicos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TecnicoDTO> getTecnicoById(@PathVariable Long id) {
        Optional<TecnicoDTO> tecnico = tecnicoService.getTecnicoById(id);
        return tecnico.map(t -> new ResponseEntity<>(t, HttpStatus.OK))
                     .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<TecnicoDTO> createTecnico(@RequestBody TecnicoDTO tecnicoDTO) {
        TecnicoDTO createdTecnico = tecnicoService.createTecnico(tecnicoDTO);
        return new ResponseEntity<>(createdTecnico, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TecnicoDTO> updateTecnico(@PathVariable Long id, @RequestBody TecnicoDTO tecnicoDetailsDTO) {
        Optional<TecnicoDTO> updatedTecnico = tecnicoService.updateTecnico(id, tecnicoDetailsDTO);
        return updatedTecnico.map(t -> new ResponseEntity<>(t, HttpStatus.OK))
                             .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTecnico(@PathVariable Long id) {
        tecnicoService.deleteTecnico(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
