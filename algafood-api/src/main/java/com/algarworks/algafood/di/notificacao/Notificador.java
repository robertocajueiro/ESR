package com.algarworks.algafood.di.notificacao;

import com.algarworks.algafood.di.modelo.Cliente;

public interface Notificador {

	void notificar(Cliente cliente, String mensagem);

}