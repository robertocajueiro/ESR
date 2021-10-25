package com.algarworks.algafood.domain.repository;

import java.util.List;

import com.algarworks.algafood.domain.model.Estado;

public interface EstadoRepository {
	
	List<Estado> listar();
	Estado buscar(Long id);
	Estado adicionar(Estado estado);
	void remover(Estado estado);

}
