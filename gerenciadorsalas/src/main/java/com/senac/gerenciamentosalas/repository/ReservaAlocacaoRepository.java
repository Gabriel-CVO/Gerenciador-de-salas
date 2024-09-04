package com.senac.gerenciamentosalas.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.senac.gerenciamentosalas.entities.ReservaAlocacao;

import jakarta.transaction.Transactional;

@Repository
public interface ReservaAlocacaoRepository extends JpaRepository <ReservaAlocacao, Integer>{

	@Query("SELECT a from ReservaAlocacao a WHERE a.status != -1")
	List<ReservaAlocacao> buscarReservasAlocacao();
	
	@Query("SELECT a from ReservaAlocacao a WHERE a.id = :id AND a.status != -1")
	Optional<ReservaAlocacao> buscarReservasAlocacaoPorId(int id);
	
	@Modifying
	@Transactional
	@Query("UPDATE ReservaAlocacao a SET a.status = -1 WHERE a.id = :id")
	void apagarReservaAlocacaoPorId(@Param("id") Integer id);
	
}
