package br.bancoeveris.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.bancoeveris.app.model.Conta;
import br.bancoeveris.app.model.Operacao;

@Repository
public interface OperacaoRepository extends JpaRepository<Operacao,Long> {
	
	Operacao findByContaDestino(Conta contaDestino);
	
	Operacao findByContaOrigem(Conta contaOrigem);

	@Query(value = "EXEC SP_OperacoesPorConta :idConta", nativeQuery = true)
    List<Operacao> findOperacoesPorConta(@Param("idConta") Long idConta);
}