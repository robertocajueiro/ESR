package com.algarworks.algafood.domain.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
@Entity
public class ItemPedido {
	
	@EqualsAndHashCode.Include
	private Long id;
	
	private Long quantidade;
	private BigDecimal precoUnitario;
	private BigDecimal precoTotal;
	private String observacao;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Pedido pedido;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Produto produto;
	
	
}
