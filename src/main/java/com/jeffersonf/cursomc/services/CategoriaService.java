package com.jeffersonf.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeffersonf.cursomc.domain.Categoria;
import com.jeffersonf.cursomc.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository catRepo;
	
	public Categoria buscar(Integer id) {
		Optional<Categoria> categoria = catRepo.findById(id);
		
		return categoria.orElse(null);		
		
		
	}
}
