package br.com.alexandre.springmvcwebapp.repository;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.alexandre.springmvcwebapp.model.Produto;
import br.com.alexandre.springmvcwebapp.model.User;
import br.com.alexandre.springmvcwebapp.model.enums.StatusPedido;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
	@Cacheable("pedidosPorStatus")
	public List<Produto> findByStatus(StatusPedido status, Pageable page);
	
	public List<Produto> findByUser(User user, Pageable page);
	
	public List<Produto> findByUserAndStatus(User user, StatusPedido status, Pageable page);

}
