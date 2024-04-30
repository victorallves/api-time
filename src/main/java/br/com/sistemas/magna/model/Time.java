package br.com.sistemas.magna.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_time")
public class Time {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nome_time", nullable = false)
	private String nomeTime;
	
	@Column(name = "nome_centro_treinamento", nullable = false)
	private String nomeCentroDeTreinamento;
	
	@Column(name = "nome_estadio", nullable = false)
	private String nomeEstadio;
	
	@JsonBackReference
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "time_id", referencedColumnName = "id")
    private Tecnico tecnico;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "time", cascade = CascadeType.ALL)
    private List<Atleta> atletas;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomeTime() {
		return nomeTime;
	}
	public void setNomeTime(String nomeTime) {
		this.nomeTime = nomeTime;
	}
	public String getNomeCentroDeTreinamento() {
		return nomeCentroDeTreinamento;
	}
	public void setNomeCentroDeTreinamento(String nomeCentroDeTreinamento) {
		this.nomeCentroDeTreinamento = nomeCentroDeTreinamento;
	}
	public String getNomeEstadio() {
		return nomeEstadio;
	}
	public void setNomeEstadio(String nomeEstadio) {
		this.nomeEstadio = nomeEstadio;
	}
	
	public Tecnico getTecnico() {
		return tecnico;
	}
	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}
	public List<Atleta> getAtletas() {
		return atletas;
	}
	public void setAtletas(List<Atleta> atletas) {
		this.atletas = atletas;
	}
	
	

}
