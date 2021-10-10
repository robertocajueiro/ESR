package com.algarworks.algafood.di.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.algarworks.algafood.di.modelo.Cliente;
import com.algarworks.algafood.di.notificacao.Notificador;

@Component
public class AtivacaoClienteService {
	
	@Autowired(required = false)
	private Notificador notificador;
	
	public void ativar(Cliente cliente) {
		cliente.ativar();
		
		if (notificador != null) {		
			notificador.notificar(cliente, "Seu cadastro no sistema esta ativo!");
	} else {
		System.out.println("Não existe notificador, mas cliente foi ativado");
		}
	}
}
	
