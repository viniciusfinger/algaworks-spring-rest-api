package com.viniciusfinger.osworks.api.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viniciusfinger.osworks.domain.model.Cliente;

@RestController
public class ClienteController {
	
	@GetMapping("/clientes")
	public List<Cliente> listar() {
		var cliente1 = new Cliente();
		var cliente2 = new Cliente();
		cliente1.setId(1l);
		cliente1.setNome("Vinicius");
		cliente1.setTelefone("51983043447");
		cliente1.setEmail("vinicius.finger2018@gmail.com");
		cliente2.setId(2l);
		cliente2.setNome("Caue");
		cliente2.setTelefone("51983043447");
		cliente2.setEmail("vinicius@gmail.com");
		
		return Arrays.asList(cliente1, cliente2);
		
	}
	

}
