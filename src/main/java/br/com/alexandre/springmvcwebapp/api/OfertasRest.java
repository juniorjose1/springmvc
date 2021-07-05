package br.com.alexandre.springmvcwebapp.api;

import java.security.Principal;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alexandre.springmvcwebapp.model.Oferta;
import br.com.alexandre.springmvcwebapp.model.Produto;
import br.com.alexandre.springmvcwebapp.model.User;
import br.com.alexandre.springmvcwebapp.model.dto.OfertaDto;
import br.com.alexandre.springmvcwebapp.repository.ProdutoRepository;
import br.com.alexandre.springmvcwebapp.repository.UserRepository;

@RestController
@RequestMapping("/api/ofertas")
public class OfertasRest {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/novo")
	public Produto criarOferta(@Valid @RequestBody OfertaDto ofertaDto, Principal principal) {
		Optional<Produto> produto = produtoRepository.findById(ofertaDto.getPedidoId());
		if(produto.isEmpty()) {
			return null;
		}
		User user = userRepository.findByUsername(principal.getName());
		
		Oferta oferta = ofertaDto.toOferta();
		Produto produtoEncontrado = produto.get();
		produtoEncontrado.getOfertas().add(oferta);
		oferta.setProduto(produtoEncontrado);
		oferta.setUser(user);
		produtoRepository.save(produtoEncontrado);
		
		return produtoEncontrado;
		
	}

}
