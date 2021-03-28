package com.store.collectibles.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.store.collectibles.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	public List<Produto> findAllByTituloProdutoContainingIgnoreCase(String tituloProduto);
	public List<Produto> findAllByValorLessThanEqual(float valor);
	public List<Produto> findAllByValorGreaterThanEqual(float valor);
	
	@Query(value = "SELECT * FROM produto WHERE ativo = :ativo", nativeQuery = true)
	public List<Produto> findAllByAtivo(@Param("ativo") boolean ativo);

}
