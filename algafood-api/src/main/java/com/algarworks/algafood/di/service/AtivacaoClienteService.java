package com.algarworks.algafood.di.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.algarworks.algafood.di.modelo.Cliente;
import com.algarworks.algafood.di.notificacao.Notificador;

@Component
public class AtivacaoClienteService {
	
	@Autowired
	private Notificador notificador;
	
//	@Autowired
//	public AtivacaoClienteService(Notificador notificador) {
//		this.notificador = notificador;
//	}
	
//	public AtivacaoClienteService(String qualquer) {
//		
//	}

	public void ativar(Cliente cliente) {
		cliente.ativar();
				
		notificador.notificar(cliente, "Seu cadastro no sistema esta ativo!");
	}

//	@Autowired
//	public void setNotificador(Notificador notificador) {
//		this.notificador = notificador;
//	}
	
	

}
