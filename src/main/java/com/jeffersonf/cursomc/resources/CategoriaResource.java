package com.jeffersonf.cursomc.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jeffersonf.cursomc.DTO.CategoriaDTO;
import com.jeffersonf.cursomc.domain.Categoria;
import com.jeffersonf.cursomc.services.CategoriaService;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaService catService;

	@RequestMapping(value="{id}", method=RequestMethod.GET)
	public ResponseEntity<Categoria> listar(@PathVariable Integer id) {
		
		Categoria categoria;
		
		categoria = catService.find(id);
		return ResponseEntity.ok().body(categoria);
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Categoria obj){
		obj = catService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
					.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> insert(@RequestBody Categoria obj, @PathVariable Integer id){
		obj.setId(id);
		obj = catService.update(obj);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value="{id}", method=RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable Integer id) {		
		catService.delete(id);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<CategoriaDTO>> delete() {		
		List<Categoria> list =  catService.findAll();
		List<CategoriaDTO> listDTO = list.stream().map(obj -> new CategoriaDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
		
	}

	

}
