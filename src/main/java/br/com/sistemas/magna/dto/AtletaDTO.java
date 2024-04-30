package br.com.sistemas.magna.dto;

import java.sql.Date;
import java.util.List;
import br.com.sistemas.magna.model.Estatistica;
import br.com.sistemas.magna.model.Time;

public class AtletaDTO {
	
	private String nomeCompleto;
	private String cpf;
	private Date dataNascimento;
	private Integer telefone;
	private Double salario;
	private Double valorAtleta;
	private String posicaoAtleta;
	private String nacionalidade;
	private String nomePai;
	private String nomeMae;
	private Integer numeroRegistro;
	private Integer numeroCamisa;
	private Date dataInicio;
	private Date dataTermino;
	private List<Estatistica> estatisticas;
	private Time time;
	
	public AtletaDTO() {

	}

	public AtletaDTO(String nomeCompleto, String cpf, Date dataNascimento, Integer telefone, Double salario,Double valorAtleta, String posicaoAtleta, String nacionalidade, String nomePai, String nomeMae,Integer numeroRegistro, Integer numeroCamisa, Date dataInicio, Date dataTermino,List<Estatistica> estatisticas, Time time) {

		this.nomeCompleto = nomeCompleto;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.telefone = telefone;
		this.salario = salario;
		this.valorAtleta = valorAtleta;
		this.posicaoAtleta = posicaoAtleta;
		this.nacionalidade = nacionalidade;
		this.nomePai = nomePai;
		this.nomeMae = nomeMae;
		this.numeroRegistro = numeroRegistro;
		this.numeroCamisa = numeroCamisa;
		this.dataInicio = dataInicio;
		this.dataTermino = dataTermino;
		this.estatisticas = estatisticas;
		this.time = time;
		
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Integer getTelefone() {
		return telefone;
	}

	public void setTelefone(Integer telefone) {
		this.telefone = telefone;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public Double getValorAtleta() {
		return valorAtleta;
	}

	public void setValorAtleta(Double valorAtleta) {
		this.valorAtleta = valorAtleta;
	}

	public String getPosicaoAtleta() {
		return posicaoAtleta;
	}

	public void setPosicaoAtleta(String posicaoAtleta) {
		this.posicaoAtleta = posicaoAtleta;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public String getNomePai() {
		return nomePai;
	}

	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	public Integer getNumeroRegistro() {
		return numeroRegistro;
	}

	public void setNumeroRegistro(Integer numeroRegistro) {
		this.numeroRegistro = numeroRegistro;
	}

	public Integer getNumeroCamisa() {
		return numeroCamisa;
	}

	public void setNumeroCamisa(Integer numeroCamisa) {
		this.numeroCamisa = numeroCamisa;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(Date dataTermino) {
		this.dataTermino = dataTermino;
	}

	public List<Estatistica> getEstatisticas() {
		return estatisticas;
	}

	public void setEstatisticas(List<Estatistica> estatisticas) {
		this.estatisticas = estatisticas;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}


}
