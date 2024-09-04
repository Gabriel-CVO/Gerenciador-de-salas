package com.senac.gerenciamentosalas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.senac.gerenciamentosalas.entities.RegistroUtilizacaoAmbiente;
import com.senac.gerenciamentosalas.repository.RegistroUtilizacaoAmbienteRepository;

import jakarta.transaction.Transactional;

@Service
public class RegistroUtilizacaoAmbienteService {
	private RegistroUtilizacaoAmbienteRepository registroUtilizacaoAmbienteRepository;

	public RegistroUtilizacaoAmbienteService(RegistroUtilizacaoAmbienteRepository registroUtilizacaoAmbienteRepository) {
		this.registroUtilizacaoAmbienteRepository = registroUtilizacaoAmbienteRepository;
	}
	
	@Transactional
	public List<RegistroUtilizacaoAmbiente> buscarRegistrosUtilizacaoAmbiente(){
		return registroUtilizacaoAmbienteRepository.buscarRegistrosUtilizacaoAmbiente();
	}

	@Transactional
	public Optional<RegistroUtilizacaoAmbiente> buscarRegistrosUtilizacaoAmbientePorId(int id) {
        return registroUtilizacaoAmbienteRepository.buscarRegistrosUtilizacaoAmbientePorId(id);
    }
	
	@Transactional
	public RegistroUtilizacaoAmbiente adicionarRegistroUtilizacaoAmbiente(RegistroUtilizacaoAmbiente registroUtilizacaoAmbiente) {
        return registroUtilizacaoAmbienteRepository.save(registroUtilizacaoAmbiente);
    }
	
	@Transactional
	public RegistroUtilizacaoAmbiente atualizarRegistroUtilizacaoAmbiente(RegistroUtilizacaoAmbiente registroUtilizacaoAmbiente) {
        return registroUtilizacaoAmbienteRepository.save(registroUtilizacaoAmbiente);
    }
	
	@Transactional
	public void apagarRegistroUtilizacaoAmbientePorId(int id) {
		registroUtilizacaoAmbienteRepository.apagarRegistroUtilizacaoAmbientePorId(id);
    }

}
