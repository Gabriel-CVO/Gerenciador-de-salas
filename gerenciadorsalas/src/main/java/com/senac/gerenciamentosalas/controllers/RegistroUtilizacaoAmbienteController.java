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

import com.senac.gerenciamentosalas.entities.RegistroUtilizacaoAmbiente;
import com.senac.gerenciamentosalas.services.RegistroUtilizacaoAmbienteService;

@RestController
@RequestMapping(value="/registro_utilizacao_ambiente")
public class RegistroUtilizacaoAmbienteController {
	
	private final RegistroUtilizacaoAmbienteService registroUtilizacaoAmbienteService;

	public RegistroUtilizacaoAmbienteController(RegistroUtilizacaoAmbienteService registroUtilizacaoAmbienteService) {
		this.registroUtilizacaoAmbienteService = registroUtilizacaoAmbienteService;
	}
	
	@GetMapping
	public ResponseEntity<List<RegistroUtilizacaoAmbiente>> obterRegistroUtilizacaoAmbiente(){
		List<RegistroUtilizacaoAmbiente> registroUtilizacaoAmbiente = registroUtilizacaoAmbienteService.buscarRegistrosUtilizacaoAmbiente();
		return new ResponseEntity<>(registroUtilizacaoAmbiente, HttpStatus.OK);
	}
	
	@GetMapping(value = "obterRegistroUtilizacaoAmbientePorId/{id}")    
    public ResponseEntity<Optional<RegistroUtilizacaoAmbiente>> getRegistroUtilizacaoAmbienteporId(@PathVariable int id){
        Optional<RegistroUtilizacaoAmbiente> registroUtilizacaoAmbiente = registroUtilizacaoAmbienteService.buscarRegistrosUtilizacaoAmbientePorId(id);
        if(registroUtilizacaoAmbiente.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(registroUtilizacaoAmbiente);
    }
	
	@PostMapping("/adicionar")
	public ResponseEntity<RegistroUtilizacaoAmbiente> adicionarRegistroUtilizacaoAmbiente(@RequestBody RegistroUtilizacaoAmbiente registroUtilizacaoAmbiente){
		RegistroUtilizacaoAmbiente novoRegistroUtilizacaoAmbiente = registroUtilizacaoAmbienteService.adicionarRegistroUtilizacaoAmbiente(registroUtilizacaoAmbiente);
		return new ResponseEntity<>(novoRegistroUtilizacaoAmbiente, HttpStatus.CREATED);
	}
	
	@PutMapping("/atualizar")
	public ResponseEntity<RegistroUtilizacaoAmbiente> atualizarRegistroUtilizacaoAmbiente(@RequestBody RegistroUtilizacaoAmbiente registroUtilizacaoAmbiente){
		RegistroUtilizacaoAmbiente atualizarRegistroUtilizacaoAmbiente = registroUtilizacaoAmbienteService.atualizarRegistroUtilizacaoAmbiente(registroUtilizacaoAmbiente);
		return new ResponseEntity<>(atualizarRegistroUtilizacaoAmbiente, HttpStatus.OK);
	}
	
	@DeleteMapping("/apagar/{id}")
	public ResponseEntity<?> excluirRegistroUtilizacaoAmbiente(@PathVariable("id") Integer id){
		registroUtilizacaoAmbienteService.apagarRegistroUtilizacaoAmbientePorId(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
