package com.senac.gerenciamentosalas.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "dias_sem_alocacao")
public class DiasSemAlocacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "dias_sem_alocacao_id", nullable = false)
	private int id;
	
	@Column(columnDefinition = "DATE", name = "dias_sem_alocacao_data", nullable = false)
	private LocalDate data;
	
	@Column(columnDefinition = "INT", name = "dias_sem_alocacao_dia_semana", nullable = false)
	private int diaSemana;
	
	@Column(columnDefinition = "TIME", name = "dias_sem_alocacao_horario_inicio", nullable = false)
	private LocalTime horarioInicio;
	
	@Column(columnDefinition = "TIME", name = "dias_sem_alocacao_horario_fim", nullable = false)
	private LocalTime horarioFim;
	
	@Column(columnDefinition = "INT", name = "dias_sem_alocacao_status", nullable = false)
	private int status;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ambiente_id",
	referencedColumnName = "ambiente_id")
	private Ambiente ambiente;
	

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

	public int getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(int diaSemana) {
		this.diaSemana = diaSemana;
	}


	public LocalTime getHorarioInicio() {
		return horarioInicio;
	}

	public void setHorarioInicio(LocalTime horarioInicio) {
		this.horarioInicio = horarioInicio;
	}

	public LocalTime getHorarioFim() {
		return horarioFim;
	}

	public void setHorarioFim(LocalTime horarioFim) {
		this.horarioFim = horarioFim;
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
	

}
