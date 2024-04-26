package br.com.sistemas.magna.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.sistemas.magna.model.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {

}
