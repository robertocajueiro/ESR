package com.algarworks.algafood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algarworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algarworks.algafood.domain.model.Cozinha;
import com.algarworks.algafood.domain.model.Restaurante;
import com.algarworks.algafood.domain.repository.RestauranteRepository;

@Service
public class CadastroRestauranteService {
	
	private static final String MSG_RESTAURANTE_NAO_ENCONTRADO =
			"Não existe cadastro de cozinha com código %d";

	@Autowired
	private RestauranteRepository restauranteRepository;
	
	@Autowired
	private CadastroCozinhaService cadastroCozinha;
	
	public Restaurante salvar(Restaurante restaurante) {
		Long cozinhaId = restaurante.getCozinha().getId();
		
		Cozinha cozinha = cadastroCozinha.buscarOuFalhar(cozinhaId);
		
		restaurante.setCozinha(cozinha);
		
		return restauranteRepository.save(restaurante);
	}
	
	public Restaurante buscarOuFalhar(Long restauranteId) {
		return restauranteRepository.findById(restauranteId)
				.orElseThrow(() -> new EntidadeNaoEncontradaException(
						String.format(MSG_RESTAURANTE_NAO_ENCONTRADO, restauranteId)));
	}

}
