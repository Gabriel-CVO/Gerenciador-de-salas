package com.senac.gerenciamentosalas.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.senac.gerenciamentosalas.entities.Usuario;

import jakarta.transaction.Transactional;

@Repository
public interface UsuarioRepository extends JpaRepository <Usuario, Integer>{

	@Query("SELECT a from Usuario a WHERE a.status != -1")
	List<Usuario> buscarUsuarios();
	
	@Query("SELECT a from Usuario a WHERE a.id = :id AND a.status != -1")
	Optional<Usuario> buscarUsuariosPorId(int id);
	
	@Modifying
	@Transactional
	@Query("UPDATE Usuario a SET a.status = -1 WHERE a.id = :id")
	void apagarUsuarioPorId(@Param("id") Integer id);
	
}
