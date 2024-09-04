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

import com.senac.gerenciamentosalas.entities.PlanejamentoAlocacao;
import com.senac.gerenciamentosalas.services.PlanejamentoAlocacaoService;

@RestController
@RequestMapping(value="/planejamento_alocacao")
public class PlanejamentoAlocacaoController {
	
	private final PlanejamentoAlocacaoService planejamentoAlocacaoService;

	public PlanejamentoAlocacaoController(PlanejamentoAlocacaoService planejamentoAlocacaoService) {
		this.planejamentoAlocacaoService = planejamentoAlocacaoService;
	}
	
	@GetMapping
	public ResponseEntity<List<PlanejamentoAlocacao>> obterPlanejamentoAlocacao(){
		List<PlanejamentoAlocacao> planejamentoAlocacao = planejamentoAlocacaoService.buscarPlanejamentosAlocacao();
		return new ResponseEntity<>(planejamentoAlocacao, HttpStatus.OK);
	}
	
	@GetMapping(value = "obterPlanejamentoAlocacaoPorId/{id}")    
    public ResponseEntity<Optional<PlanejamentoAlocacao>> getPlanejamentoAlocacaoporId(@PathVariable int id){
        Optional<PlanejamentoAlocacao> planejamentoAlocacao = planejamentoAlocacaoService.buscarPlanejamentosAlocacaoPorId(id);
        if(planejamentoAlocacao.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(planejamentoAlocacao);
    }
	
	@PostMapping("/adicionar")
	public ResponseEntity<PlanejamentoAlocacao> adicionarPlanejamentoAlocacao(@RequestBody PlanejamentoAlocacao planejamentoAlocacao){
		PlanejamentoAlocacao novoPlanejamentoAlocacao = planejamentoAlocacaoService.adicionarPlanejamentoAlocacao(planejamentoAlocacao);
		return new ResponseEntity<>(novoPlanejamentoAlocacao, HttpStatus.CREATED);
	}
	
	@PutMapping("/atualizar")
	public ResponseEntity<PlanejamentoAlocacao> atualizarPlanejamentoAlocacao(@RequestBody PlanejamentoAlocacao planejamentoAlocacao){
		PlanejamentoAlocacao atualizarPlanejamentoAlocacao = planejamentoAlocacaoService.atualizarPlanejamentoAlocacao(planejamentoAlocacao);
		return new ResponseEntity<>(atualizarPlanejamentoAlocacao, HttpStatus.OK);
	}
	
	@DeleteMapping("/apagar/{id}")
	public ResponseEntity<?> excluirPlanejamentoAlocacao(@PathVariable("id") Integer id){
		planejamentoAlocacaoService.apagarPlanejamentoAlocacaoPorId(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
