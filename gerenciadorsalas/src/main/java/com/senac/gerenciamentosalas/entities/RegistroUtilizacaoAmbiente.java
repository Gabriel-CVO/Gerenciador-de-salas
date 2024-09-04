package com.senac.gerenciamentosalas.entities;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "registro_utilizacao_ambiente")
public class RegistroUtilizacaoAmbiente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "registro_utilizacao_ambiente_id", nullable = false)
	private int id;
	
	@Column(columnDefinition = "DATETIME", name = "registro_utilizacao_ambiente_hora_entrada", nullable = false)
	private LocalDateTime horaEntrada;
	
	@Column(columnDefinition = "DATETIME", name = "registro_utilizacao_ambiente_hora_saida", nullable = false)
	private LocalDateTime horaSaida;
	
	@Column(columnDefinition = "INT", name = "registro_utilizacao_ambiente_status", nullable = false)
	private int status;
	
	@Column(columnDefinition = "VARCHAR", name = "registro_utilizacao_ambiente_observacao", nullable = false)
	private String observacao;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ambiente_id",
	referencedColumnName = "ambiente_id")
	private Ambiente ambiente;
	
	@ManyToOne
	@JoinColumn(name="planejamento_alocacao_id", nullable=false)
	private PlanejamentoAlocacao planejamentoAlocacao;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "usuario_id_retirada",
	referencedColumnName = "usuario_id")
	private Usuario usuarioRetirada;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "usuario_id_devolucao",
	referencedColumnName = "usuario_id")
	private Usuario usuarioDevolucao;

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getHoraEntrada() {
		return horaEntrada;
	}

	public void setHoraEntrada(LocalDateTime horaEntrada) {
		this.horaEntrada = horaEntrada;
	}

	public LocalDateTime getHoraSaida() {
		return horaSaida;
	}

	public void setHoraSaida(LocalDateTime horaSaida) {
		this.horaSaida = horaSaida;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Ambiente getAmbiente() {
		return ambiente;
	}

	public void setAmbiente(Ambiente ambiente) {
		this.ambiente = ambiente;
	}

	public PlanejamentoAlocacao getPlanejamentoAlocacao() {
		return planejamentoAlocacao;
	}

	public void setPlanejamentoAlocacao(PlanejamentoAlocacao planejamentoAlocacao) {
		this.planejamentoAlocacao = planejamentoAlocacao;
	}

	public Usuario getUsuarioRetirada() {
		return usuarioRetirada;
	}

	public void setUsuarioRetirada(Usuario usuarioRetirada) {
		this.usuarioRetirada = usuarioRetirada;
	}

	public Usuario getUsuarioDevolucao() {
		return usuarioDevolucao;
	}

	public void setUsuarioDevolucao(Usuario usuarioDevolucao) {
		this.usuarioDevolucao = usuarioDevolucao;
	}

	

	
	
}
