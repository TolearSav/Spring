package com.store.collectibles.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.store.collectibles.model.Loja;

@Repository
public interface LojaRepository extends JpaRepository<Loja, Long> {
	public List<Loja> findAllByNomeLojaContainingIgnoreCase(String nomeLoja);
	public List<Loja> findAllByDescricaoContainingIgnoreCase(String descricao);
	

}
