package com.algarworks.algafood;

import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;

import com.algarworks.algafood.di.notificacao.NotificadorEmail;
import com.algarworks.algafood.di.service.AtivacaoClienteService;

//@Configuration
public class AlgaConfig {

	@Bean
	public NotificadorEmail notificadorEmail() {
		NotificadorEmail notificador = new NotificadorEmail("smtp.algamail.com.br");
		notificador.setCaixaAlta(true);
		
		return notificador;
	}
	
	@Bean
	public AtivacaoClienteService ativacaoClienteService() {
		return new AtivacaoClienteService(notificadorEmail());
	}
}


