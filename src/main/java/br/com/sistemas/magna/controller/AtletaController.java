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
import br.com.sistemas.magna.dto.AtletaDTO;
import br.com.sistemas.magna.service.AtletaService;

@RestController
@RequestMapping("/atletas")
public class AtletaController {

    @Autowired
    private AtletaService atletaService;

    @GetMapping
    public List<AtletaDTO> getAllAtletas() {
        return atletaService.getAllAtletas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AtletaDTO> getAtletaById(@PathVariable Long id) {
        Optional<AtletaDTO> atleta = atletaService.getAtletaById(id);
        return atleta.map(a -> new ResponseEntity<>(a, HttpStatus.OK))
                     .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<AtletaDTO> createAtleta(@RequestBody AtletaDTO atletaDTO) {
        AtletaDTO createdAtleta = atletaService.createAtleta(atletaDTO);
        return new ResponseEntity<>(createdAtleta, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AtletaDTO> updateAtleta(@PathVariable Long id, @RequestBody AtletaDTO atletaDetailsDTO) {
        Optional<AtletaDTO> updatedAtleta = atletaService.updateAtleta(id, atletaDetailsDTO);
        return updatedAtleta.map(a -> new ResponseEntity<>(a, HttpStatus.OK))
                            .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAtleta(@PathVariable Long id) {
        atletaService.deleteAtleta(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
