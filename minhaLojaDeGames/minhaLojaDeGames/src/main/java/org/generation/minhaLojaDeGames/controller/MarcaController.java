package org.generation.minhaLojaDeGames.controller;

import java.util.List;

import org.generation.minhaLojaDeGames.models.Marca;
import org.generation.minhaLojaDeGames.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/marca")
@CrossOrigin("*")
public class MarcaController {
	
	@Autowired
	private MarcaRepository repository;
	@GetMapping
	public ResponseEntity<List<Marca>>getAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Marca> getById(@PathVariable long id) {
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Marca>> getByNome(@PathVariable String nome){
		return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
	}
	
	@PostMapping
	public ResponseEntity<Marca> post (@RequestBody Marca marca){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(marca));
	}
	
	@PutMapping
	public ResponseEntity<Marca> put (@RequestBody Marca marca){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(marca));
	}
	
	@DeleteMapping("/{id}")
	public void  delete(@PathVariable long id){
		repository.deleteById(id);
	}


}
