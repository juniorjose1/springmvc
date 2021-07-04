package br.com.alexandre.springmvcwebapp.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alexandre.springmvcwebapp.model.Produto;
import br.com.alexandre.springmvcwebapp.model.User;
import br.com.alexandre.springmvcwebapp.model.enums.StatusPedido;
import br.com.alexandre.springmvcwebapp.repository.ProdutoRepository;
import br.com.alexandre.springmvcwebapp.repository.UserRepository;

@Controller
@RequestMapping("/usuario/pedidos")
public class UsuarioController {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping
	public String meusPedidos(Model model, Principal principal) {
		
		User user = userRepository.findByUsername(principal.getName());
		
		Sort sort = Sort.by("data").descending();
		
		PageRequest page = PageRequest.of(0, 5, sort);
		
		List<Produto> produtos = produtoRepository.findByUser(user, page);
		model.addAttribute("listaProdutos", produtos);
		return "/usuario/pedidos";
	}
	
	@GetMapping("/{status}")
	public String findStatus(@PathVariable String status, Model model, Principal principal) {
		
		Sort sort = Sort.by("data").descending();
		
		PageRequest page = PageRequest.of(0, 5, sort);
		
		User user = userRepository.findByUsername(principal.getName());
		List<Produto> produtos = produtoRepository.findByUserAndStatus(user, StatusPedido.valueOf(status.toUpperCase()), page);
		model.addAttribute("listaProdutos", produtos);
		model.addAttribute("status", status);
		return "/usuario/pedidos";
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public String notFound(Model model) {
		return "redirect:/usuario/pedidos";
	}

}
