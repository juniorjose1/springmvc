package br.com.alexandre.springmvcwebapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.alexandre.springmvcwebapp.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
