package com.algarworks.algafood.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algarworks.algafood.domain.model.Restaurante;

public interface RestauranteRepository extends JpaRepository<Restaurante, Long>{
	

}
