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

import br.com.sistemas.magna.model.Estatistica;
import br.com.sistemas.magna.repository.EstatisticaRepository;

@RestController
@RequestMapping("/estatistica")
public class EstatisticaController {

	@Autowired
    private EstatisticaRepository estatisticaRepository;

    @GetMapping
    public List<Estatistica> getAllEstatistica() {
        return estatisticaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estatistica> getEstatisticaById(@PathVariable Long id) {
    	Estatistica estatistica = estatisticaRepository.findById(id)
                                  .orElse(null);
        if (estatistica != null) {
            return new ResponseEntity<>(estatistica, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Estatistica> createEstatistica(@RequestBody Estatistica estatistica) {
        try {
        	Estatistica createdEstatistica = estatisticaRepository.save(estatistica);
            return new ResponseEntity<>(createdEstatistica, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estatistica> updateEstatistica(@PathVariable Long id, @RequestBody Estatistica estatisticaDetails) {
    	Estatistica estatistica = estatisticaRepository.findById(id)
                                  .orElse(null);
        if (estatistica != null) {
        	estatistica.setNumeroDeGols(estatisticaDetails.getNumeroDeGols());
        	//faltam gets e sets
            return new ResponseEntity<>(estatisticaRepository.save(estatistica), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Estatistica> deleteEstatistica(@PathVariable Long id) {
        try {
        	estatisticaRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
	
	
}
