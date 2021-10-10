package com.algarworks.algafood.di.service;

import org.springframework.stereotype.Component;

import com.algarworks.algafood.di.modelo.Cliente;
import com.algarworks.algafood.di.notificacao.NotificadorEmail;

@Component
public class AtivacaoClienteService {
	
	private NotificadorEmail notificador;
	
	public void ativar(Cliente cliente) {
		cliente.ativar();
		
		
		this.notificador.notificar(cliente, "Seu cadastro no sistema est� ativo!");
	}

}
