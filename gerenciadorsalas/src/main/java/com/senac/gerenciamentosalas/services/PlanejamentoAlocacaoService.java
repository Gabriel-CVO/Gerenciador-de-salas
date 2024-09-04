package com.senac.gerenciamentosalas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.senac.gerenciamentosalas.entities.PlanejamentoAlocacao;
import com.senac.gerenciamentosalas.repository.PlanejamentoAlocacaoRepository;

import jakarta.transaction.Transactional;

@Service
public class PlanejamentoAlocacaoService {
	private PlanejamentoAlocacaoRepository planejamentoAlocacaoRepository;

	public PlanejamentoAlocacaoService(PlanejamentoAlocacaoRepository planejamentoAlocacaoRepository) {
		this.planejamentoAlocacaoRepository = planejamentoAlocacaoRepository;
	}
	
	@Transactional
	public List<PlanejamentoAlocacao> buscarPlanejamentosAlocacao(){
		return planejamentoAlocacaoRepository.buscarPlanejamentosAlocacao();
	}

	@Transactional
	public Optional<PlanejamentoAlocacao> buscarPlanejamentosAlocacaoPorId(int id) {
        return planejamentoAlocacaoRepository.buscarPlanejamentosAlocacaoPorId(id);
    }
	
	@Transactional
	public PlanejamentoAlocacao adicionarPlanejamentoAlocacao(PlanejamentoAlocacao planejamentoAlocacao) {
        return planejamentoAlocacaoRepository.save(planejamentoAlocacao);
    }
	
	@Transactional
	public PlanejamentoAlocacao atualizarPlanejamentoAlocacao(PlanejamentoAlocacao planejamentoAlocacao) {
        return planejamentoAlocacaoRepository.save(planejamentoAlocacao);
    }
	
	@Transactional
	public void apagarPlanejamentoAlocacaoPorId(int id) {
		planejamentoAlocacaoRepository.apagarPlanejamentoAlocacaoPorId(id);
    }

}
