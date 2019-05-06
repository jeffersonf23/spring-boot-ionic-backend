package com.jeffersonf.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeffersonf.cursomc.domain.Cliente;
import com.jeffersonf.cursomc.repositories.ClienteRepository;
import com.jeffersonf.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository cliRepo;
	
	public Cliente find(Integer id) {
		Optional<Cliente> cliente = cliRepo.findById(id);
		
		return cliente.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));		
		
		
	}
}
