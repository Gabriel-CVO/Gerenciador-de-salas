package com.senac.gerenciamentosalas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.senac.gerenciamentosalas.entities.DiasSemAlocacao;
import com.senac.gerenciamentosalas.repository.DiasSemAlocacaoRepository;

import jakarta.transaction.Transactional;

@Service
public class DiasSemAlocacaoService {
	private DiasSemAlocacaoRepository diasSemAlocacaoRepository;
	
	public DiasSemAlocacaoService(DiasSemAlocacaoRepository diasSemAlocacaoRepository) {
		this.diasSemAlocacaoRepository = diasSemAlocacaoRepository;
	}
	
	@Transactional
	public List<DiasSemAlocacao> buscarDiasSemAlocacao(){
		return diasSemAlocacaoRepository.buscarDiasSemAlocacao();
	}

	@Transactional
	public Optional<DiasSemAlocacao> buscarDiasSemAlocacaoPorId(int id) {
        return diasSemAlocacaoRepository.buscarDiasSemAlocacaoPorId(id);
    }
	
	@Transactional
	public DiasSemAlocacao adicionarDiasSemAlocacao(DiasSemAlocacao diasSemAlocacao) {
        return diasSemAlocacaoRepository.save(diasSemAlocacao);
    }
	
	@Transactional
	public DiasSemAlocacao atualizarDiasSemAlocacao(DiasSemAlocacao diasSemAlocacao) {
        return diasSemAlocacaoRepository.save(diasSemAlocacao);
    }
	
	@Transactional
	public void apagarDiasSemAlocacaoPorId(int id) {
		diasSemAlocacaoRepository.apagarDiasSemAlocacaoPorId(id);
    }

}
