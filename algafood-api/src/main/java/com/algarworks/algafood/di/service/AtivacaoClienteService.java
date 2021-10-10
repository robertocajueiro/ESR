package com.algarworks.algafood.di.service;

import org.springframework.stereotype.Component;

import com.algarworks.algafood.di.modelo.Cliente;
import com.algarworks.algafood.di.notificacao.Notificador;

@Component
public class AtivacaoClienteService {
	
	private Notificador notificador;
	
	
	
	public AtivacaoClienteService(Notificador notificador) {
		this.notificador = notificador;
		
		System.out.println("Ativação Cliente Service: " + notificador);
	}



	public void ativar(Cliente cliente) {
		cliente.ativar();
		
		
		notificador.notificar(cliente, "Seu cadastro no sistema esta ativo!");
	}

}
