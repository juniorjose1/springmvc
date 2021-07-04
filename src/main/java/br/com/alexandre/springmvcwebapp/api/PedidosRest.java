package br.com.alexandre.springmvcwebapp.api;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alexandre.springmvcwebapp.model.Produto;
import br.com.alexandre.springmvcwebapp.model.User;
import br.com.alexandre.springmvcwebapp.repository.ProdutoRepository;
import br.com.alexandre.springmvcwebapp.repository.UserRepository;

@RestController
@RequestMapping("/api/pedidos")
public class PedidosRest {
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping
	public List<Produto> produtos(Principal principal){
		
		User user = userRepository.findByUsername(principal.getName());
		
		Sort sort = Sort.by("data").descending();
		
		PageRequest page = PageRequest.of(0, 5, sort);
		
		List<Produto> produtos = produtoRepository.findByUser(user, page);
		
		return produtos;
	}

}
