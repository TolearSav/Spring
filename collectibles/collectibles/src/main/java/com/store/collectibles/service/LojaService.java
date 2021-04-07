package com.store.collectibles.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.collectibles.model.Loja;
import com.store.collectibles.model.Usuario;
import com.store.collectibles.repository.LojaRepository;
import com.store.collectibles.repository.UsuarioRepository;

@Service
public class LojaService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private LojaRepository lojaRepository;
	
	public Loja cadastroUsuarioLoja(long lojaId, long usuarioId) {
		Optional<Usuario> usuarioExistente = usuarioRepository.findById(usuarioId);
		Optional<Loja> lojaExistente = lojaRepository.findById(lojaId);
		
		if(usuarioExistente.isPresent() && lojaExistente.isPresent()){
			lojaExistente.get().getUsuarios().add(usuarioExistente.get());
			
			lojaRepository.save(lojaExistente.get());
			
			return lojaRepository.save(lojaExistente.get());
		}
		
		return null;
	}
	

}