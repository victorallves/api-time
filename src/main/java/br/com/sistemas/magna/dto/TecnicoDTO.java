package br.com.sistemas.magna.dto;

import br.com.sistemas.magna.model.Time;

public class TecnicoDTO {
	private String nomeTecnico;
	private String nacionalidade;
	private Double valorTecnico;
	private Double salario;
	private String areaAtuacao;
	private Time time;

	public TecnicoDTO() {

	}

	public TecnicoDTO(String nomeTecnico, String nacionalidade, Double valorTecnico, Double salario, String areaAtuacao, Time time) {

		this.nomeTecnico = nomeTecnico;
		this.nacionalidade = nacionalidade;
		this.valorTecnico = valorTecnico;
		this.salario = salario;
		this.areaAtuacao = areaAtuacao;
		this.time = time;
		
	}

	public String getNomeTecnico() {
		return nomeTecnico;
	}

	public void setNomeTecnico(String nomeTecnico) {
		this.nomeTecnico = nomeTecnico;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public Double getValorTecnico() {
		return valorTecnico;
	}

	public void setValorTecnico(Double valorTecnico) {
		this.valorTecnico = valorTecnico;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public String getAreaAtuacao() {
		return areaAtuacao;
	}

	public void setAreaAtuacao(String areaAtuacao) {
		this.areaAtuacao = areaAtuacao;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}
	
	

}
