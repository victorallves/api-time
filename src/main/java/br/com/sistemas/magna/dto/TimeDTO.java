package br.com.sistemas.magna.dto;

import java.util.List;

import br.com.sistemas.magna.model.Atleta;
import br.com.sistemas.magna.model.Tecnico;

public class TimeDTO {
	private String nomeTime;
	private String nomeCentroDeTreinamento;
	private String nomeEstadio;
	private Tecnico tecnico;
	private List<Atleta> atletas;

	public TimeDTO() {

		
	}

	public TimeDTO(String nomeTime, String nomeCentroDeTreinamento, String nomeEstadio, Tecnico tecnico, List<Atleta> atletas) {

		this.nomeTime = nomeTime;
		this.nomeCentroDeTreinamento = nomeCentroDeTreinamento;
		this.nomeEstadio = nomeEstadio;
		this.tecnico = tecnico;
		this.atletas = atletas;
		
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
