package br.com.alexandre.springmvcwebapp.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alexandre.springmvcwebapp.model.Produto;
import br.com.alexandre.springmvcwebapp.model.User;
import br.com.alexandre.springmvcwebapp.model.dto.ProdutoDto;
import br.com.alexandre.springmvcwebapp.repository.ProdutoRepository;
import br.com.alexandre.springmvcwebapp.repository.UserRepository;

@Controller
@RequestMapping("pedido")
public class PedidoController {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping
	public String form(ProdutoDto produtoDto) {
		return "pedido/formulario";
	}
	
	@PostMapping("novo")
	public String cadastrarPedido(@Valid ProdutoDto produtoDto, BindingResult binding, Principal principal) {
		
		if(binding.hasErrors()) {
			return "pedido/formulario";
		}
		
		Produto produto = produtoDto.toProduto();
		User user = userRepository.findByUsername(principal.getName());
		produto.setUser(user);
		
		produtoRepository.save(produto);
		
		return "redirect:/home";
	}

}
