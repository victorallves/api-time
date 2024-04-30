package br.com.sistemas.magna.dto;

import br.com.sistemas.magna.model.Atleta;

public class EstatisticaDTO {
	private Integer numeroDeGols;
	private Integer numeroDeCartaoAmarelo;
	private Integer numeroDeCartaoVermelho;
	private String nomeCampeonato;
	private Atleta atleta;

	public EstatisticaDTO() {

	}

	public EstatisticaDTO(Integer numeroDeGols, Integer numeroDeCartaoAmarelo, Integer numeroDeCartaoVermelho,String nomeCampeonato, Atleta atleta) {

		this.numeroDeGols = numeroDeGols;
		this.numeroDeCartaoAmarelo = numeroDeCartaoAmarelo;
		this.numeroDeCartaoVermelho = numeroDeCartaoVermelho;
		this.nomeCampeonato = nomeCampeonato;
		this.atleta = atleta;

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

	public Atleta getAtleta() {
		return atleta;
	}

	public void setAtleta(Atleta atleta) {
		this.atleta = atleta;
	}

}
