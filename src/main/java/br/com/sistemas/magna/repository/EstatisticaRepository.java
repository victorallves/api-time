package br.com.sistemas.magna.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.sistemas.magna.model.Estatistica;

@Repository
public interface EstatisticaRepository extends JpaRepository<Estatistica, Long> {

}
