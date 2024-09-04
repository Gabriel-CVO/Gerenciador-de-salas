package com.senac.gerenciamentosalas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.senac.gerenciamentosalas.entities.Usuario;
import com.senac.gerenciamentosalas.repository.UsuarioRepository;

import jakarta.transaction.Transactional;

@Service
public class UsuarioService {
	private UsuarioRepository usuarioRepository;

	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	
	@Transactional
	public List<Usuario> buscarUsuarios(){
		return usuarioRepository.buscarUsuarios();
	}

	@Transactional
	public Optional<Usuario> buscarUsuariosPorId(int id) {
        return usuarioRepository.buscarUsuariosPorId(id);
    }
	
	@Transactional
	public Usuario adicionarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
	
	@Transactional
	public Usuario atualizarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
	
	@Transactional
	public void apagarUsuarioPorId(int id) {
		usuarioRepository.apagarUsuarioPorId(id);
    }

}
