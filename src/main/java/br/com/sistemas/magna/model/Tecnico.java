package br.com.sistemas.magna.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_tecnico")
public class Tecnico {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
	@Column(name = "nome_tecnico", nullable = false)
    private String nomeTecnico;
	
	@Column(name = "nacionalidade", nullable = false)
    private String nacionalidade;

	@Column(name = "valor_tecnico", nullable = false)
    private Double valorTecnico;
	
	@Column(name = "salario", nullable = false)
    private Double salario;
	
	@Column(name = "area_atuacao", nullable = false)
    private Double areaAtuacao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Double getAreaAtuacao() {
		return areaAtuacao;
	}

	public void setAreaAtuacao(Double areaAtuacao) {
		this.areaAtuacao = areaAtuacao;
	}

	
}
