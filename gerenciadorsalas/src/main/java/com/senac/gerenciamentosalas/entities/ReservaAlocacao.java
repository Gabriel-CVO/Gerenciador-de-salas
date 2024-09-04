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
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "reserva_alocacao")
public class ReservaAlocacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "reserva_alocacao_id", nullable = false)
	private int id;
	
	@Column(columnDefinition = "VARCHAR", name = "reserva_alocacao_justificativa", nullable = false)
	private String justificativa;
	
	@Column(columnDefinition = "DATE", name = "reserva_alocacao_data", nullable = false)
	private LocalDate data;
	
	@Column(columnDefinition = "TIME", name = "reserva_alocacao_hora_inicio", nullable = false)
	private LocalTime horaInicio;
	
	@Column(columnDefinition = "TIME", name = "reserva_alocacao_hora_fim", nullable = false)
	private LocalTime horaFim;
	
	@Column(columnDefinition = "INT", name = "reserva_alocacao_status", nullable = false)
	private int status;
	
	@OneToMany(mappedBy="reservaAlocacao")
	private Set<PlanejamentoAlocacao> planejamentos_alocacao;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "usuario_id",
	referencedColumnName = "usuario_id")
	private Usuario usuario;

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getJustificativa() {
		return justificativa;
	}

	public void setJustificativa(String justificativa) {
		this.justificativa = justificativa;
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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Set<PlanejamentoAlocacao> getPlanejamentos_alocacao() {
		return planejamentos_alocacao;
	}

	public void setPlanejamentos_alocacao(Set<PlanejamentoAlocacao> planejamentos_alocacao) {
		this.planejamentos_alocacao = planejamentos_alocacao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	

}
