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

import br.com.sistemas.magna.model.Funcionarios;
import br.com.sistemas.magna.repository.FuncionariosRepository;

@RestController
@RequestMapping("/funcionarios")
public class FuncionariosController {

	  @Autowired
	    private FuncionariosRepository funcionariosRepository;

	    @GetMapping
	    public List<Funcionarios> getAllFuncionarios() {
	        return funcionariosRepository.findAll();
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Funcionarios> getFuncionariosById(@PathVariable Long id) {
	    	Funcionarios funcionarios = funcionariosRepository.findById(id)
	                                  .orElse(null);
	        if (funcionarios != null) {
	            return new ResponseEntity<>(funcionarios, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }

	    @PostMapping
	    public ResponseEntity<Funcionarios> createFuncionarios(@RequestBody Funcionarios funcionarios) {
	        try {
	        	Funcionarios createdfuncionarios = funcionariosRepository.save(funcionarios);
	            return new ResponseEntity<>(createdfuncionarios, HttpStatus.CREATED);
	        } catch (Exception e) {
	            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Funcionarios> updateFuncionarios(@PathVariable Long id, @RequestBody Funcionarios funcionariosDetails) {
	    	Funcionarios funcionarios = funcionariosRepository.findById(id)
	                                  .orElse(null);
	        if (funcionarios != null) {
	        	funcionarios.setNomeCompleto(funcionariosDetails.getNomeCompleto());
	        	//faltam gets e sets
	            return new ResponseEntity<>(funcionariosRepository.save(funcionarios), HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Funcionarios> deleteFuncionarios(@PathVariable Long id) {
	        try {
	        	funcionariosRepository.deleteById(id);
	            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	        } catch (Exception e) {
	            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }
	
}
