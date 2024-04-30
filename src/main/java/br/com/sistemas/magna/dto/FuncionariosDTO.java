package br.com.sistemas.magna.dto;

import java.sql.Date;

import br.com.sistemas.magna.model.Time;

public class FuncionariosDTO {
	private String nomeCompleto;
	private Date dataNascimento;
	private String cargo;
	private Double salario;

	public FuncionariosDTO() {

	}

	public FuncionariosDTO(String nomeCompleto, Date dataNascimento, String cargo, Double salario, Time time) {

		this.nomeCompleto = nomeCompleto;
		this.dataNascimento = dataNascimento;
		this.cargo = cargo;
		this.salario = salario;

	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	
}
