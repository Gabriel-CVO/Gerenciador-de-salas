package com.senac.gerenciamentosalas.entities;

import java.time.LocalDateTime;
import java.util.Set;

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
@Table(name = "usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "usuario_id", nullable = false)
	private int id;
	
	@Column(columnDefinition = "VARCHAR", name = "usuario_nome", nullable = false)
	private String nome;
	
	@Column(columnDefinition = "VARCHAR", name = "usuario_matricula", nullable = false)
	private String matricula;
	
	@Column(columnDefinition = "INT", name = "usuario_tipo", nullable = false)
	private int tipo;
	
	@Column(columnDefinition = "INT", name = "usuario_status", nullable = false)
	private int status;
	
	@Column(columnDefinition = "DATETIME", name = "usuario_log_data_criacao", nullable = false)
	private LocalDateTime logDataCriacao;
	
	@OneToOne(mappedBy = "usuario")
	private PlanejamentoAlocacao planejamentoAlocacao;
	
	@OneToOne(mappedBy = "usuarioRetirada")
	private RegistroUtilizacaoAmbiente registroUtilizacaoAmbienteRetirada;
	
	@OneToOne(mappedBy = "usuarioDevolucao")
	private RegistroUtilizacaoAmbiente registroUtilizacaoAmbienteDevolucao;
	
	@OneToOne(mappedBy = "usuario")
	private ReservaAlocacao reservaAlocacao;
	
	@OneToMany(mappedBy="usuarioResponsavel")
	private Set<Usuario> usuariosResponsaveis;

	@ManyToOne
	@JoinColumn(name="usuario_lod_responsavel_id", nullable=true)
	private Usuario usuarioResponsavel;

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public LocalDateTime getLogDataCriacao() {
		return logDataCriacao;
	}

	public void setLogDataCriacao(LocalDateTime logDataCriacao) {
		this.logDataCriacao = logDataCriacao;
	}

	public PlanejamentoAlocacao getPlanejamentoAlocacao() {
		return planejamentoAlocacao;
	}

	public void setPlanejamentoAlocacao(PlanejamentoAlocacao planejamentoAlocacao) {
		this.planejamentoAlocacao = planejamentoAlocacao;
	}

	public RegistroUtilizacaoAmbiente getRegistroUtilizacaoAmbienteRetirada() {
		return registroUtilizacaoAmbienteRetirada;
	}

	public void setRegistroUtilizacaoAmbienteRetirada(RegistroUtilizacaoAmbiente registroUtilizacaoAmbienteRetirada) {
		this.registroUtilizacaoAmbienteRetirada = registroUtilizacaoAmbienteRetirada;
	}

	public RegistroUtilizacaoAmbiente getRegistroUtilizacaoAmbienteDevolucao() {
		return registroUtilizacaoAmbienteDevolucao;
	}

	public void setRegistroUtilizacaoAmbienteDevolucao(RegistroUtilizacaoAmbiente registroUtilizacaoAmbienteDevolucao) {
		this.registroUtilizacaoAmbienteDevolucao = registroUtilizacaoAmbienteDevolucao;
	}

	public ReservaAlocacao getReservaAlocacao() {
		return reservaAlocacao;
	}

	public void setReservaAlocacao(ReservaAlocacao reservaAlocacao) {
		this.reservaAlocacao = reservaAlocacao;
	}

	public Set<Usuario> getUsuariosResponsaveis() {
		return usuariosResponsaveis;
	}

	public void setUsuariosResponsaveis(Set<Usuario> usuariosResponsaveis) {
		this.usuariosResponsaveis = usuariosResponsaveis;
	}

	public Usuario getUsuarioResponsavel() {
		return usuarioResponsavel;
	}

	public void setUsuarioResponsavel(Usuario usuarioResponsavel) {
		this.usuarioResponsavel = usuarioResponsavel;
	}

	
	

}
