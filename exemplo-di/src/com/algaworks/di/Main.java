package com.algaworks.di;

import com.algaworks.di.modelo.Cliente;
import com.algaworks.di.notificacao.Notificador;
//import com.algaworks.di.notificacao.NotificadorEmail;
import com.algaworks.di.notificacao.NotificadorSMS;
import com.algaworks.di.service.AtivacaoClienteService;

public class Main {
	
	public static void main(String [] args) {
		Cliente joao = new Cliente("João", "joao@xyz.com", "88997766");
		Cliente maria = new Cliente("Maria", "maria@zxc.com", "123456789");
		
		//Notificador notificador = new NotificadorEmail();
		Notificador notificador = new NotificadorSMS();
		
		AtivacaoClienteService ativacaoCliente = new AtivacaoClienteService(notificador);
		ativacaoCliente.ativar(joao);
		ativacaoCliente.ativar(maria);
	}

}
