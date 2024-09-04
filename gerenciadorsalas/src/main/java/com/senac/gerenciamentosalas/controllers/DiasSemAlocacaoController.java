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

import com.senac.gerenciamentosalas.entities.DiasSemAlocacao;
import com.senac.gerenciamentosalas.services.DiasSemAlocacaoService;

@RestController
@RequestMapping(value="/dias_sem_alocacao")
public class DiasSemAlocacaoController {
	
	private final DiasSemAlocacaoService diasSemAlocacaoService;

	public DiasSemAlocacaoController(DiasSemAlocacaoService diasSemAlocacaoService) {
		this.diasSemAlocacaoService = diasSemAlocacaoService;
	}
	
	@GetMapping
	public ResponseEntity<List<DiasSemAlocacao>> obterDiasSemAlocacao(){
		List<DiasSemAlocacao> diasSemAlocacao = diasSemAlocacaoService.buscarDiasSemAlocacao();
		return new ResponseEntity<>(diasSemAlocacao, HttpStatus.OK);
	}
	
	@GetMapping(value = "obterDiasSemAlocacaoPorId/{id}")    
    public ResponseEntity<Optional<DiasSemAlocacao>> getDiasSemAlocacaoporId(@PathVariable int id){
        Optional<DiasSemAlocacao> diasSemAlocacao = diasSemAlocacaoService.buscarDiasSemAlocacaoPorId(id);
        if(diasSemAlocacao.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(diasSemAlocacao);
    }
	
	@PostMapping("/adicionar")
	public ResponseEntity<DiasSemAlocacao> adicionarDiasSemAlocacao(@RequestBody DiasSemAlocacao diasSemAlocacao){
		DiasSemAlocacao novoDiasSemAlocacao = diasSemAlocacaoService.adicionarDiasSemAlocacao(diasSemAlocacao);
		return new ResponseEntity<>(novoDiasSemAlocacao, HttpStatus.CREATED);
	}
	
	@PutMapping("/atualizar")
	public ResponseEntity<DiasSemAlocacao> atualizarDiasSemAlocacao(@RequestBody DiasSemAlocacao diasSemAlocacao){
		DiasSemAlocacao atualizarDiasSemAlocacao = diasSemAlocacaoService.atualizarDiasSemAlocacao(diasSemAlocacao);
		return new ResponseEntity<>(atualizarDiasSemAlocacao, HttpStatus.OK);
	}
	
	@DeleteMapping("/apagar/{id}")
	public ResponseEntity<?> excluirDiasSemAlocacao(@PathVariable("id") Integer id){
		diasSemAlocacaoService.apagarDiasSemAlocacaoPorId(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
