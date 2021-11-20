package com.algarworks.algafood.domain.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Produto {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JoinColumn(nullable = false)
	private String nome;
	
	@JoinColumn(nullable = false)
	private String descricao;
	
	@JoinColumn(nullable = false)
	private BigDecimal preco;
	
	@JoinColumn(nullable = false)
	private Boolean ativo; 
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Restaurante restaurante;
	
}
