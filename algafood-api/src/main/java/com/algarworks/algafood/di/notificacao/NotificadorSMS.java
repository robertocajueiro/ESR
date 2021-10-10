package com.algarworks.algafood.di.notificacao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.algarworks.algafood.di.modelo.Cliente;

@Qualifier("sms")
@Component
public class NotificadorSMS implements Notificador {
	
	@Override
	public void notificar(Cliente cliente, String mensagem) {
		System.out.printf("Notificando %s por SMS atraves do telefone %s: %s\n",
				cliente.getNome(), cliente.getTelefone(), mensagem);
	}
	

}
