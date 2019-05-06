package com.jeffersonf.cursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jeffersonf.cursomc.domain.Cliente;
import com.jeffersonf.cursomc.services.ClienteService;

@RestController
@RequestMapping(value="/cliente")
public class ClienteResource {
	
	@Autowired
	private ClienteService cliService;

	@RequestMapping(value="{id}", method=RequestMethod.GET)
	 public ResponseEntity<Cliente> listar(@PathVariable Integer id) {
		
		Cliente cliente;
		
		cliente = cliService.find(id);
		return ResponseEntity.ok().body(cliente);
		
	 }

}
