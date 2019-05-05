package com.jeffersonf.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeffersonf.cursomc.domain.Cliente;
import com.jeffersonf.cursomc.domain.Pedido;
import com.jeffersonf.cursomc.repositories.PedidoRepository;
import com.jeffersonf.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepo;
	
	public Pedido buscar(Integer id) {
		Optional<Pedido> pedido = pedidoRepo.findById(id);
		
		return pedido.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));		
		
		
	}
}
