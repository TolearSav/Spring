package org.generation.minhaLojaDeGames.controller;

import java.util.List;

import org.generation.minhaLojaDeGames.models.Acessorios;
import org.generation.minhaLojaDeGames.repository.AcessoriosRepository;
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
@RequestMapping("/acessorios")
@CrossOrigin("*")
public class AcessoriosController {
	
	@Autowired
	private AcessoriosRepository repository;
	@GetMapping
	public ResponseEntity<List<Acessorios>>getAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Acessorios> getById(@PathVariable long id) {
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Acessorios>> getByNome(@PathVariable String nome){
		return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
	}
	
	@PostMapping
	public ResponseEntity<Acessorios> post (@RequestBody Acessorios acessorios){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(acessorios));
	}
	
	@PutMapping
	public ResponseEntity<Acessorios> put (@RequestBody Acessorios acessorios){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(acessorios));
	}
	
	@DeleteMapping("/{id}")
	public void  delete(@PathVariable long id){
		repository.deleteById(id);
	}


}
