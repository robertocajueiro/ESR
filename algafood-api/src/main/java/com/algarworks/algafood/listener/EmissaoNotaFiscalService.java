package com.algarworks.algafood.listener;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.algarworks.algafood.di.service.ClienteAtivadoEvent;

@Component
public class EmissaoNotaFiscalService {
	
	@EventListener
	public void clienteAtivadoListener(ClienteAtivadoEvent event) {
		System.out.println("Emitindo nota fiscal para cliente " + event.getCliente().getNome());
	}

}
