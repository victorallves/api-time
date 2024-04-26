package br.com.sistemas.magna.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.sistemas.magna.model.Tecnico;

public interface TecnicoRepository extends JpaRepository<Tecnico, Long> {

}
