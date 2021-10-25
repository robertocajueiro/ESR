package com.algarworks.algafood.domain.repository;

import java.util.List;

import com.algarworks.algafood.domain.model.Restaurante;

public interface RestauranteRepository {
	
	List<Restaurante> todas();
	Restaurante porId(Long id);
	Restaurante adicionar(Restaurante restaurante);
	void remover(Restaurante restaurante);

}
