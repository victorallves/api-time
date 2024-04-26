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

import br.com.sistemas.magna.model.Tecnico;
import br.com.sistemas.magna.repository.TecnicoRepository;

@RestController
@RequestMapping("/tecnico")
public class TecnicoController {

	  @Autowired
	    private TecnicoRepository tecnicoRepository;

	    @GetMapping
	    public List<Tecnico> getAllTecnico() {
	        return tecnicoRepository.findAll();
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Tecnico> getTecnicoById(@PathVariable Long id) {
	    	Tecnico tecnico = tecnicoRepository.findById(id)
	                                  .orElse(null);
	        if (tecnico != null) {
	            return new ResponseEntity<>(tecnico, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }

	    @PostMapping
	    public ResponseEntity<Tecnico> createTecnico(@RequestBody Tecnico tecnico) {
	        try {
	            Tecnico createdTecnico = tecnicoRepository.save(tecnico);
	            return new ResponseEntity<>(createdTecnico, HttpStatus.CREATED);
	        } catch (Exception e) {
	            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Tecnico> updateTecnico(@PathVariable Long id, @RequestBody Tecnico tecnicoDetails) {
	    	Tecnico tecnico = tecnicoRepository.findById(id)
	                                  .orElse(null);
	        if (tecnico != null) {
	        	tecnico.setNomeTecnico(tecnicoDetails.getNomeTecnico());
	
	            return new ResponseEntity<>(tecnicoRepository.save(tecnico), HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Tecnico> deleteTecnico(@PathVariable Long id) {
	        try {
	        	tecnicoRepository.deleteById(id);
	            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	        } catch (Exception e) {
	            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }
	
}
