package com.viniciusfinger.osworks.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.viniciusfinger.osworks.entities.Cliente;
import com.viniciusfinger.osworks.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;
	
	public ResponseEntity<List<Cliente>> findAll() {
		List<Cliente> lista = repository.findAll();
		return ResponseEntity.ok(lista);
	}

	public Cliente findById(long id) {
		Optional<Cliente> obj = repository.findById(id);
		return obj.get();
	}
	
	public ResponseEntity<Cliente> save(Cliente cliente) {
		try {
			repository.save(cliente);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} return new ResponseEntity<>(cliente, HttpStatus.CREATED);
	}
	
	public ResponseEntity<Cliente> update(Long id, Cliente cliente) {
		if (!repository.existsById(id)) {
			return ResponseEntity.notFound().build(); 
		} else {
			cliente.setId(id);
			cliente = repository.save(cliente); 
			return ResponseEntity.ok(cliente);
		}
	}

	public ResponseEntity<String> delete(Long id) {
		if (!repository.existsById(id)) {
			return ResponseEntity.notFound().build();
		} else {
			repository.deleteById(id);
			return ResponseEntity.ok("Cliente removido com sucesso.");
		}
	}
	
	public ResponseEntity<List<Cliente>> findByNomeContaining(String name) {
		List<Cliente> clientes = repository.findByNomeContaining(name);
		if (clientes.size() <= 0) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok(clientes);
		}
	}
}