package com.algarworks.algafood.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algarworks.algafood.domain.model.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {
	
}
