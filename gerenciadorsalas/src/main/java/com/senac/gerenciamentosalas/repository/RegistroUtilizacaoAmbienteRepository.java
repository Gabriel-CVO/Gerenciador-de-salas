package com.senac.gerenciamentosalas.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.senac.gerenciamentosalas.entities.RegistroUtilizacaoAmbiente;

import jakarta.transaction.Transactional;

@Repository
public interface RegistroUtilizacaoAmbienteRepository extends JpaRepository <RegistroUtilizacaoAmbiente, Integer>{

	@Query("SELECT a from RegistroUtilizacaoAmbiente a WHERE a.status != -1")
	List<RegistroUtilizacaoAmbiente> buscarRegistrosUtilizacaoAmbiente();
	
	@Query("SELECT a from RegistroUtilizacaoAmbiente a WHERE a.id = :id AND a.status != -1")
	Optional<RegistroUtilizacaoAmbiente> buscarRegistrosUtilizacaoAmbientePorId(int id);
	
	@Modifying
	@Transactional
	@Query("UPDATE RegistroUtilizacaoAmbiente a SET a.status = -1 WHERE a.id = :id")
	void apagarRegistroUtilizacaoAmbientePorId(@Param("id") Integer id);
	
}
