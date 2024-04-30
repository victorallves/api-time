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

import br.com.sistemas.magna.dto.EstatisticaDTO;
import br.com.sistemas.magna.service.EstatisticaService;

@RestController
@RequestMapping("/estatisticas")
public class EstatisticaController {

    @Autowired
    private EstatisticaService estatisticaService;

    @GetMapping
    public List<EstatisticaDTO> getAllEstatisticas() {
        return estatisticaService.getAllEstatisticas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstatisticaDTO> getEstatisticaById(@PathVariable Long id) {
        Optional<EstatisticaDTO> estatistica = estatisticaService.getEstatisticaById(id);
        return estatistica.map(e -> new ResponseEntity<>(e, HttpStatus.OK))
                          .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<EstatisticaDTO> createEstatistica(@RequestBody EstatisticaDTO estatisticaDTO) {
        EstatisticaDTO createdEstatistica = estatisticaService.createEstatistica(estatisticaDTO);
        return new ResponseEntity<>(createdEstatistica, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstatisticaDTO> updateEstatistica(@PathVariable Long id, @RequestBody EstatisticaDTO estatisticaDetailsDTO) {
        Optional<EstatisticaDTO> updatedEstatistica = estatisticaService.updateEstatistica(id, estatisticaDetailsDTO);
        return updatedEstatistica.map(e -> new ResponseEntity<>(e, HttpStatus.OK))
                                 .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEstatistica(@PathVariable Long id) {
        estatisticaService.deleteEstatistica(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
