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
import br.com.sistemas.magna.dto.FuncionariosDTO;
import br.com.sistemas.magna.service.FuncionariosService;

@RestController
@RequestMapping("/funcionarios")
public class FuncionariosController {

    @Autowired
    private FuncionariosService funcionariosService;

    @GetMapping
    public List<FuncionariosDTO> getAllFuncionarios() {
        return funcionariosService.getAllFuncionarios();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FuncionariosDTO> getFuncionariosById(@PathVariable Long id) {
        Optional<FuncionariosDTO> funcionarios = funcionariosService.getFuncionariosById(id);
        return funcionarios.map(funcionario -> new ResponseEntity<>(funcionario, HttpStatus.OK))
                           .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<FuncionariosDTO> createFuncionarios(@RequestBody FuncionariosDTO funcionariosDTO) {
        FuncionariosDTO createdFuncionarios = funcionariosService.createFuncionarios(funcionariosDTO);
        return new ResponseEntity<>(createdFuncionarios, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FuncionariosDTO> updateFuncionarios(@PathVariable Long id, @RequestBody FuncionariosDTO funcionariosDetailsDTO) {
        Optional<FuncionariosDTO> updatedFuncionarios = funcionariosService.updateFuncionarios(id, funcionariosDetailsDTO);
        return updatedFuncionarios.map(funcionario -> new ResponseEntity<>(funcionario, HttpStatus.OK))
                                  .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFuncionarios(@PathVariable Long id) {
        funcionariosService.deleteFuncionarios(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
