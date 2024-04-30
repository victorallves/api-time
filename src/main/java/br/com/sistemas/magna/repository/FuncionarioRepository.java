package br.com.sistemas.magna.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sistemas.magna.model.Funcionarios;

public interface FuncionarioRepository extends JpaRepository<Funcionarios, Long> {

}
