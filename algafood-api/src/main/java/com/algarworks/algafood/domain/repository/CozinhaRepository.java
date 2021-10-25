package com.algarworks.algafood.domain.repository;

import java.util.List;

import com.algarworks.algafood.domain.model.Cozinha;

public interface CozinhaRepository {
	
	List<Cozinha> todas();
	Cozinha porId(Long id);
	Cozinha adicionar(Cozinha cozinha);
	void remover(Cozinha cozinha);

}
