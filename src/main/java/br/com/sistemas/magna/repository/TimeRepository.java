package br.com.sistemas.magna.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.sistemas.magna.model.Time;

@Repository
public interface TimeRepository extends JpaRepository<Time, Long> {

}
