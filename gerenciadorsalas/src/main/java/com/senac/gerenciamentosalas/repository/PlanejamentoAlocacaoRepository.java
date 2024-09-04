package com.senac.gerenciamentosalas.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.senac.gerenciamentosalas.entities.PlanejamentoAlocacao;

import jakarta.transaction.Transactional;

@Repository
public interface PlanejamentoAlocacaoRepository extends JpaRepository <PlanejamentoAlocacao, Integer>{

	@Query("SELECT a from PlanejamentoAlocacao a WHERE a.status != -1")
	List<PlanejamentoAlocacao> buscarPlanejamentosAlocacao();
	
	@Query("SELECT a from PlanejamentoAlocacao a WHERE a.id = :id AND a.status != -1")
	Optional<PlanejamentoAlocacao> buscarPlanejamentosAlocacaoPorId(int id);
	
	@Modifying
	@Transactional
	@Query("UPDATE PlanejamentoAlocacao a SET a.status = -1 WHERE a.id = :id")
	void apagarPlanejamentoAlocacaoPorId(@Param("id") Integer id);
	
}
