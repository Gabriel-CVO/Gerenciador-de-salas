package com.senac.gerenciamentosalas.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ambiente")
public class Ambiente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ambiente_id", nullable = false)
	private int id;
	
	@Column(columnDefinition = "VARCHAR", name = "ambiente_descricao", nullable = false)
	private String descricao;
	
	@Column(columnDefinition = "INT", name = "ambiente_andar", nullable = false)
	private int andar;
	
	@Column(columnDefinition = "VARCHAR", name = "ambiente_tipo", nullable = false)
	private String tipo;
	
	@Column(columnDefinition = "INT", name = "ambiente_numero_pcs", nullable = false)
	private int numeroPcs;
	
	@Column(columnDefinition = "INT", name = "ambiente_capacidade", nullable = false)
	private int capacidade;
	
	@Column(columnDefinition = "INT", name = "ambiente_status", nullable = false)
	private int status;
	
	@OneToOne(mappedBy = "ambiente")
	private PlanejamentoAlocacao planejamentoAlocacao;
	
	@OneToOne(mappedBy = "ambiente")
	private RegistroUtilizacaoAmbiente registroUtilizacaoAmbiente;
	
	@OneToOne(mappedBy = "ambiente")
	private DiasSemAlocacao diasSemAlocacao;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getAndar() {
		return andar;
	}

	public void setAndar(int andar) {
		this.andar = andar;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getNumeroPcs() {
		return numeroPcs;
	}

	public void setNumeroPcs(int numeroPcs) {
		this.numeroPcs = numeroPcs;
	}

	public int getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public PlanejamentoAlocacao getPlanejamentoAlocacao() {
		return planejamentoAlocacao;
	}

	public void setPlanejamentoAlocacao(PlanejamentoAlocacao planejamentoAlocacao) {
		this.planejamentoAlocacao = planejamentoAlocacao;
	}

	public RegistroUtilizacaoAmbiente getRegistroUtilizacaoAmbiente() {
		return registroUtilizacaoAmbiente;
	}

	public void setRegistroUtilizacaoAmbiente(RegistroUtilizacaoAmbiente registroUtilizacaoAmbiente) {
		this.registroUtilizacaoAmbiente = registroUtilizacaoAmbiente;
	}

	public DiasSemAlocacao getDiasSemAlocacao() {
		return diasSemAlocacao;
	}

	public void setDiasSemAlocacao(DiasSemAlocacao diasSemAlocacao) {
		this.diasSemAlocacao = diasSemAlocacao;
	}

	
	
}
