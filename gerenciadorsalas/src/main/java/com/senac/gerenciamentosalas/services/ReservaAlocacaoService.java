package com.senac.gerenciamentosalas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.senac.gerenciamentosalas.entities.ReservaAlocacao;
import com.senac.gerenciamentosalas.repository.ReservaAlocacaoRepository;

import jakarta.transaction.Transactional;

@Service
public class ReservaAlocacaoService {
	private ReservaAlocacaoRepository reservaAlocacaoRepository;

	public ReservaAlocacaoService(ReservaAlocacaoRepository reservaAlocacaoRepository) {
		this.reservaAlocacaoRepository = reservaAlocacaoRepository;
	}
	
	@Transactional
	public List<ReservaAlocacao> buscarReservasAlocacao(){
		return reservaAlocacaoRepository.buscarReservasAlocacao();
	}

	@Transactional
	public Optional<ReservaAlocacao> buscarReservasAlocacaoPorId(int id) {
        return reservaAlocacaoRepository.buscarReservasAlocacaoPorId(id);
    }
	
	@Transactional
	public ReservaAlocacao adicionarReservaAlocacao(ReservaAlocacao reservaAlocacao) {
        return reservaAlocacaoRepository.save(reservaAlocacao);
    }
	
	@Transactional
	public ReservaAlocacao atualizarReservaAlocacao(ReservaAlocacao reservaAlocacao) {
        return reservaAlocacaoRepository.save(reservaAlocacao);
    }
	
	@Transactional
	public void apagarReservaAlocacaoPorId(int id) {
		reservaAlocacaoRepository.apagarReservaAlocacaoPorId(id);
    }

}
