package com.senac.gerenciamentosalas.services;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.senac.gerenciamentosalas.entities.Ambiente;
import com.senac.gerenciamentosalas.repository.AmbienteRepository;

import jakarta.transaction.Transactional;

@Service
public class AmbienteService {
	private AmbienteRepository ambienteRepository;
	
	public AmbienteService(AmbienteRepository ambienteRepository) {
		this.ambienteRepository = ambienteRepository;
	}
	
	@Transactional
	public List<Ambiente> buscarAmbientes(){
		return ambienteRepository.buscarAmbientes();
	}

	@Transactional
	public Optional<Ambiente> buscarAmbientesPorId(int id) {
        return ambienteRepository.buscarAmbientesPorId(id);
    }
	
	@Transactional
	public Ambiente adicionarAmbiente(Ambiente ambiente) {
        return ambienteRepository.save(ambiente);
    }
	
	@Transactional
	public Ambiente atualizarAmbiente(Ambiente ambiente) {
        return ambienteRepository.save(ambiente);
    }
	
	@Transactional
	public void apagarAmbientePorId(int id) {
        ambienteRepository.apagarAmbientePorId(id);
    }
	
}
