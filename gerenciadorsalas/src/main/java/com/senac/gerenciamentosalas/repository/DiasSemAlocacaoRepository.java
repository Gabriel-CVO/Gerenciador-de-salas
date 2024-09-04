package com.senac.gerenciamentosalas.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.senac.gerenciamentosalas.entities.DiasSemAlocacao;

import jakarta.transaction.Transactional;

@Repository
public interface DiasSemAlocacaoRepository extends JpaRepository <DiasSemAlocacao, Integer>{

	@Query("SELECT a from DiasSemAlocacao a WHERE a.status != -1")
	List<DiasSemAlocacao> buscarDiasSemAlocacao();
	
	@Query("SELECT a from DiasSemAlocacao a WHERE a.id = :id AND a.status != -1")
	Optional<DiasSemAlocacao> buscarDiasSemAlocacaoPorId(int id);
	
	@Modifying
	@Transactional
	@Query("UPDATE DiasSemAlocacao a SET a.status = -1 WHERE a.id = :id")
	void apagarDiasSemAlocacaoPorId(@Param("id") Integer id);
	
}
