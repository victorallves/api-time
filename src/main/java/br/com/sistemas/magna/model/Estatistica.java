package br.com.sistemas.magna.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_estatistica")
public class Estatistica {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
	@Column(name = "numero_gols", nullable = false)
    private Integer numeroDeGols;
	
	@Column(name = "numero_de_cartao_amarelo", nullable = false)
    private Integer numeroDeCartaoAmarelo;

	@Column(name = "numero_de_cartao_vermelho", nullable = false)
    private Integer numeroDeCartaoVermelho;
	
	@Column(name = "nome_campeonato", nullable = false)
    private String nomeCampeonato;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNumeroDeGols() {
		return numeroDeGols;
	}

	public void setNumeroDeGols(Integer numeroDeGols) {
		this.numeroDeGols = numeroDeGols;
	}

	public Integer getNumeroDeCartaoAmarelo() {
		return numeroDeCartaoAmarelo;
	}

	public void setNumeroDeCartaoAmarelo(Integer numeroDeCartaoAmarelo) {
		this.numeroDeCartaoAmarelo = numeroDeCartaoAmarelo;
	}

	public Integer getNumeroDeCartaoVermelho() {
		return numeroDeCartaoVermelho;
	}

	public void setNumeroDeCartaoVermelho(Integer numeroDeCartaoVermelho) {
		this.numeroDeCartaoVermelho = numeroDeCartaoVermelho;
	}

	public String getNomeCampeonato() {
		return nomeCampeonato;
	}

	public void setNomeCampeonato(String nomeCampeonato) {
		this.nomeCampeonato = nomeCampeonato;
	}

	
	
}
