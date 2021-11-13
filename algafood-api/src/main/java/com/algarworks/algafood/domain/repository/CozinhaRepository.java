package com.algarworks.algafood.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.algarworks.algafood.domain.model.Cozinha;

@Repository
public interface CozinhaRepository extends CustomJpaRepository<Cozinha, Long> {
	
	List<Cozinha> findTodasByNomeContaining(String nome); // Containing usa Like %%
	
	Optional<Cozinha> findByNome(String nome);
	
	boolean existsByNome(String nome);

}
