package com.algarworks.algafood.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algarworks.algafood.AlgafoodApiApplication;
import com.algarworks.algafood.domain.model.Estado;
import com.algarworks.algafood.domain.repository.EstadoRepository;

public class ConsultaEstadoMain {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		EstadoRepository estadoRepository = applicationContext.getBean(EstadoRepository.class);
		
		List<Estado> Estados =  estadoRepository.listar();
		
				for (Estado estado : Estados) {
					System.out.printf("%s - %s\n", estado.getId(), estado.getNome());
				}
	}

}
