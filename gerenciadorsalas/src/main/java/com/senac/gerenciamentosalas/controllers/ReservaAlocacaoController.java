package com.senac.gerenciamentosalas.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senac.gerenciamentosalas.entities.ReservaAlocacao;
import com.senac.gerenciamentosalas.services.ReservaAlocacaoService;

@RestController
@RequestMapping(value="/reserva_alocacao")
public class ReservaAlocacaoController {
	
	private final ReservaAlocacaoService reservaAlocacaoService;

	public ReservaAlocacaoController(ReservaAlocacaoService reservaAlocacaoService) {
		this.reservaAlocacaoService = reservaAlocacaoService;
	}
	
	@GetMapping
	public ResponseEntity<List<ReservaAlocacao>> obterReservaAlocacao(){
		List<ReservaAlocacao> reservaAlocacao = reservaAlocacaoService.buscarReservasAlocacao();
		return new ResponseEntity<>(reservaAlocacao, HttpStatus.OK);
	}
	
	@GetMapping(value = "obterReservaAlocacaoPorId/{id}")    
    public ResponseEntity<Optional<ReservaAlocacao>> getReservaAlocacaoporId(@PathVariable int id){
        Optional<ReservaAlocacao> reservaAlocacao = reservaAlocacaoService.buscarReservasAlocacaoPorId(id);
        if(reservaAlocacao.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(reservaAlocacao);
    }
	
	@PostMapping("/adicionar")
	public ResponseEntity<ReservaAlocacao> adicionarReservaAlocacao(@RequestBody ReservaAlocacao reservaAlocacao){
		ReservaAlocacao novaReservaAlocacao = reservaAlocacaoService.adicionarReservaAlocacao(reservaAlocacao);
		return new ResponseEntity<>(novaReservaAlocacao, HttpStatus.CREATED);
	}
	
	@PutMapping("/atualizar")
	public ResponseEntity<ReservaAlocacao> atualizarReservaAlocacao(@RequestBody ReservaAlocacao reservaAlocacao){
		ReservaAlocacao atualizarReservaAlocacao = reservaAlocacaoService.atualizarReservaAlocacao(reservaAlocacao);
		return new ResponseEntity<>(atualizarReservaAlocacao, HttpStatus.OK);
	}
	
	@DeleteMapping("/apagar/{id}")
	public ResponseEntity<?> excluirReservaAlocacao(@PathVariable("id") Integer id){
		reservaAlocacaoService.apagarReservaAlocacaoPorId(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
