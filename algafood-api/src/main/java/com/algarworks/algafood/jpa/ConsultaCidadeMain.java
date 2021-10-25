package com.algarworks.algafood.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algarworks.algafood.AlgafoodApiApplication;
import com.algarworks.algafood.domain.model.Cidade;
import com.algarworks.algafood.domain.repository.CidadeRepository;

public class ConsultaCidadeMain {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		CidadeRepository cidadeRepository = applicationContext.getBean(CidadeRepository.class);
		
		List<Cidade> Cidades =  cidadeRepository.listar();
		
				for (Cidade cidade : Cidades) {
					System.out.printf("%s - %s\n", cidade.getId(), cidade.getNome());
				}
	}

}
