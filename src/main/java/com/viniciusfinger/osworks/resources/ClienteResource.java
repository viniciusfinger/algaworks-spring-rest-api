package com.viniciusfinger.osworks.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viniciusfinger.osworks.entities.Cliente;
import com.viniciusfinger.osworks.services.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteResource {

	@Autowired
	private ClienteService service;

	@GetMapping
	public ResponseEntity<List<Cliente>> listarTodos() {
		return service.findAll();
	}

	@GetMapping("/{clienteId}")
	public ResponseEntity<Cliente> buscaClienteEspecifico(@PathVariable Long clienteId) {
		Cliente cliente = service.findById(clienteId);
		return ResponseEntity.ok(cliente);
	}

	@PostMapping
	public ResponseEntity<Cliente> adicionaCliente(@Valid @RequestBody Cliente cliente) {
		return service.save(cliente);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Cliente> atualizaCliente(@Valid @PathVariable Long id, @RequestBody Cliente cliente) {
		return service.update(id, cliente);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletaCliente(@PathVariable Long id) {
		return service.delete(id);
	}
}