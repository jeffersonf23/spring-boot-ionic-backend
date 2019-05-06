package com.jeffersonf.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeffersonf.cursomc.domain.Categoria;
import com.jeffersonf.cursomc.repositories.CategoriaRepository;
import com.jeffersonf.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository catRepo;
	
	public Categoria find(Integer id) {
		Optional<Categoria> categoria = catRepo.findById(id);
		
		return categoria.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));		
	}

	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return catRepo.save(obj);
	}
	
	public Categoria update(Categoria obj) {
		find(obj.getId());
		return catRepo.save(obj);
	}

}
