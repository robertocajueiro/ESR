package com.algarworks.algafood.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algarworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algarworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algarworks.algafood.domain.model.Cidade;
import com.algarworks.algafood.domain.repository.CidadeRepository;
import com.algarworks.algafood.domain.service.CadastroCidadeService;

@RestController
@RequestMapping(value = "/cidades")
public class CidadeController {
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private CadastroCidadeService cadastroCidade;
	
	@GetMapping
	public List<Cidade> listar(){
		return cidadeRepository.findAll();
	}
	
	@GetMapping("/{cidadeId}")
	public ResponseEntity<Cidade> buscar(@PathVariable Long cidadeId){
		Optional<Cidade> cidade = cidadeRepository.findById(cidadeId);
		
		if (cidade.isPresent()) {
			return ResponseEntity.ok(cidade.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cidade adicionar(@RequestBody Cidade cidade) {
		return cadastroCidade.salvar(cidade);
	}
	
	@PutMapping("/{cidadeId}")
	public ResponseEntity<Cidade> atualizar(@PathVariable Long cidadeId,
			@RequestBody Cidade cidade){
		Optional<Cidade> cidadeAtual = cidadeRepository.findById(cidadeId);
		
		if (cidadeAtual.isPresent()) {
		BeanUtils.copyProperties(cidade, cidadeAtual.get(), "id");
		
		Cidade cidadeSalva = cadastroCidade.salvar(cidadeAtual.get());
		return ResponseEntity.ok(cidadeSalva);
	}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("cidadeId")
	public ResponseEntity<Cidade> remover(@PathVariable Long cidadeId) {
		try {
			cadastroCidade.excluir(cidadeId);
			return ResponseEntity.noContent().build();
			
		} catch(EntidadeNaoEncontradaException e) {
			return ResponseEntity.notFound().build();
		
		} catch(EntidadeEmUsoException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}
	

}
