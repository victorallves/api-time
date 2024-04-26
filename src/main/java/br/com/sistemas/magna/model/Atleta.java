package br.com.sistemas.magna.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_atleta")
public class Atleta {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
	@Column(name = "nome_completo", nullable = false)
    private String nomeCompleto;
	
	@Column(name = "cpf", nullable = false)
    private String cpf;

	@Column(name = "data_nascimento", nullable = false)
    private Date dataNascimento;
	
	@Column(name = "telefone", nullable = false)
    private Integer telefone;
	
	@Column(name = "salario", nullable = false)
    private Double salario;
	
	@Column(name = "valor_atleta", nullable = false)
    private Double valorAtleta;
	
	@Column(name = "posicao_atleta", nullable = false)
    private String posicaoAtleta;
	
	@Column(name = "nacionalidade", nullable = false)
    private String nacionalidade;
	
	@Column(name = "nome_pai", nullable = false)
    private String nomePai;
	
	@Column(name = "nome_mae", nullable = false)
    private String nomeMae;
	
	@Column(name = "numero_registro", nullable = false)
    private Integer numeroRegistro;
	
	@Column(name = "numero_camisa", nullable = false)
    private Integer numeroCamisa;
	
	@Column(name = "data_inicio_contrato", nullable = false)
    private Date dataInicio;
	
	@Column(name = "data_termino_contrato", nullable = false)
    private Date dataTermino;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	
	
	
	
}
