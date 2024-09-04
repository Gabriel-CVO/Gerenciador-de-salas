package com.senac.gerenciamentosalas.entities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "planejamento_alocacao")
public class PlanejamentoAlocacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "planejamento_alocacao_id", nullable = false)
	private int id;
	
	@Column(columnDefinition = "DATE", name = "planejamento_alocacao_data", nullable = false)
	private LocalDate data;

	@Column(columnDefinition = "TIME", name = "planejamento_alocacao_hora_inicio", nullable = false)
	private LocalTime horaInicio;
	
	@Column(columnDefinition = "TIME", name = "planejamento_alocacao_hora_fim", nullable = false)
	private LocalTime horaFim;
	
	@Column(columnDefinition = "VARCHAR", name = "planejamento_alocacao_observacao", nullable = false)
	private String descricao;
	
	@Column(columnDefinition = "INT", name = "planejamento_alocacao_status", nullable = false)
	private int status;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ambiente_id",
	referencedColumnName = "ambiente_id")
	private Ambiente ambiente;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "usuario_id",
	referencedColumnName = "usuario_id")
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name="reserva_alocacao_id", nullable=false)
	private ReservaAlocacao reservaAlocacao;
	
	@OneToMany(mappedBy="planejamentoAlocacao")
	private Set<RegistroUtilizacaoAmbiente> registrosUtilizacaoAmbiente;

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public LocalTime getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(LocalTime horaInicio) {
		this.horaInicio = horaInicio;
	}

	public LocalTime getHoraFim() {
		return horaFim;
	}

	public void setHoraFim(LocalTime horaFim) {
		this.horaFim = horaFim;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Ambiente getAmbiente() {
		return ambiente;
	}

	public void setAmbiente(Ambiente ambiente) {
		this.ambiente = ambiente;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public ReservaAlocacao getReservaAlocacao() {
		return reservaAlocacao;
	}

	public void setReservaAlocacao(ReservaAlocacao reservaAlocacao) {
		this.reservaAlocacao = reservaAlocacao;
	}

	public Set<RegistroUtilizacaoAmbiente> getRegistrosUtilizacaoAmbiente() {
		return registrosUtilizacaoAmbiente;
	}

	public void setRegistrosUtilizacaoAmbiente(Set<RegistroUtilizacaoAmbiente> registrosUtilizacaoAmbiente) {
		this.registrosUtilizacaoAmbiente = registrosUtilizacaoAmbiente;
	}

	
	
}
