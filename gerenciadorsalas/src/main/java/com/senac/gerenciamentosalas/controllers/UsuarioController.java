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

import com.senac.gerenciamentosalas.entities.Usuario;
import com.senac.gerenciamentosalas.services.UsuarioService;

@RestController
@RequestMapping(value="/usuario")
public class UsuarioController {
	
	private final UsuarioService usuarioService;

	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	@GetMapping
	public ResponseEntity<List<Usuario>> obterUsuario(){
		List<Usuario> usuario = usuarioService.buscarUsuarios();
		return new ResponseEntity<>(usuario, HttpStatus.OK);
	}
	
	@GetMapping(value = "obterUsuarioPorId/{id}")    
    public ResponseEntity<Optional<Usuario>> getUsuarioporId(@PathVariable int id){
        Optional<Usuario> usuario = usuarioService.buscarUsuariosPorId(id);
        if(usuario.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(usuario);
    }
	
	@PostMapping("/adicionar")
	public ResponseEntity<Usuario> adicionarUsuario(@RequestBody Usuario usuario){
		Usuario novoUsuario = usuarioService.adicionarUsuario(usuario);
		return new ResponseEntity<>(novoUsuario, HttpStatus.CREATED);
	}
	
	@PutMapping("/atualizar")
	public ResponseEntity<Usuario> atualizarUsuario(@RequestBody Usuario usuario){
		Usuario atualizarUsuario = usuarioService.atualizarUsuario(usuario);
		return new ResponseEntity<>(atualizarUsuario, HttpStatus.OK);
	}
	
	@DeleteMapping("/apagar/{id}")
	public ResponseEntity<?> excluirUsuario(@PathVariable("id") Integer id){
		usuarioService.apagarUsuarioPorId(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
