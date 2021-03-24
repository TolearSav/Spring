package org.generation.minhaLojaDeGames.repository;

import java.util.List;

import org.generation.minhaLojaDeGames.models.Acessorios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AcessoriosRepository extends JpaRepository<Acessorios, Long>{
	public List<Acessorios> findAllByNomeContainingIgnoreCase (String nome);
}
