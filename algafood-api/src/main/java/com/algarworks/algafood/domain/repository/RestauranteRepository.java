package com.algarworks.algafood.domain.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.algarworks.algafood.domain.model.Restaurante;

@Repository
public interface RestauranteRepository extends JpaRepository<Restaurante, Long>{
	
	// Usando keyword Between
	List<Restaurante> findByTaxaFreteBetween(BigDecimal taxaInicial, BigDecimal taxaFinal);
	
	@Query("from Restaurante where nome like %:nome% and cozinha.id = :id")
	List<Restaurante> consultarPorNome(String nome, @Param("id") Long cozinha);
	
	
	//And
	//List<Restaurante> findByNomeContainingAndCozinhaId(String nome, Long cozinha);

	// Limit - só o primeiro registro
	Optional<Restaurante> findFirstRestauranteByNomeContaining(String nome);
	
	// Só os dois primeiros registros
	List<Restaurante> findTop2ByNomeContaining(String nome);
	
	// Quantos restaurantes existe com determinada cozinha - count
	int countByCozinhaId(Long cozinha);
}
