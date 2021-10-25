package com.algarworks.algafood.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algarworks.algafood.AlgafoodApiApplication;
import com.algarworks.algafood.domain.model.FormaPagamento;
import com.algarworks.algafood.domain.repository.FormaPagamentoRepository;

public class ConsultaFormaPagamentoMain {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		FormaPagamentoRepository formaPagamentoRepository = applicationContext.getBean(FormaPagamentoRepository.class);
		
		List<FormaPagamento> formaPagamentos =  formaPagamentoRepository.listar();
		
				for (FormaPagamento formaPagamento : formaPagamentos) {
					System.out.printf("%s - %s\n", formaPagamento.getId(), formaPagamento.getDescricao());
				}
	}

}
