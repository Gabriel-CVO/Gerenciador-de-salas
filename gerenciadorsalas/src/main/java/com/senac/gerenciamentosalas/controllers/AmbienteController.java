package com.senac.gerenciamentosalas.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senac.gerenciamentosalas.entities.Ambiente;
import com.senac.gerenciamentosalas.services.AmbienteService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(value="/ambiente")
public class AmbienteController {
	
	private final AmbienteService ambienteService;

	public AmbienteController(AmbienteService ambienteService) {
		this.ambienteService = ambienteService;
	}
	
	@GetMapping
	public ResponseEntity<List<Ambiente>> obterAmbiente(){
		List<Ambiente> ambiente = ambienteService.buscarAmbientes();
		return new ResponseEntity<>(ambiente, HttpStatus.OK);
	}
	
	@GetMapping(value = "obterAmbientePorId/{id}")    
    public ResponseEntity<Optional<Ambiente>> getAmbienteporId(@PathVariable int id){
        Optional<Ambiente> ambiente = ambienteService.buscarAmbientesPorId(id);
        if(ambiente.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(ambiente);
    }
	
	@PostMapping("/adicionar")
	public ResponseEntity<Ambiente> adicionarAmbiente(@RequestBody Ambiente ambiente){
		Ambiente novoAmbiente = ambienteService.adicionarAmbiente(ambiente);
		return new ResponseEntity<>(novoAmbiente, HttpStatus.CREATED);
	}
	
	@PutMapping("/atualizar")
	public ResponseEntity<Ambiente> atualizarAmbiente(@RequestBody Ambiente ambiente){
		Ambiente atualizarAmbiente = ambienteService.atualizarAmbiente(ambiente);
		return new ResponseEntity<>(atualizarAmbiente, HttpStatus.OK);
	}
	
	@DeleteMapping("/apagar/{id}")
	public ResponseEntity<?> excluirAmbiente(@PathVariable("id") Integer id){
		ambienteService.apagarAmbientePorId(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
