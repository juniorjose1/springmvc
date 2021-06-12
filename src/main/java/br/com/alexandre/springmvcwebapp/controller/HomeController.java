package br.com.alexandre.springmvcwebapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alexandre.springmvcwebapp.model.Produto;
import br.com.alexandre.springmvcwebapp.model.enums.StatusPedido;
import br.com.alexandre.springmvcwebapp.repository.ProdutoRepository;

@Controller
@RequestMapping("home")
public class HomeController {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@GetMapping
	public String home(Model model) {
		List<Produto> produtos = produtoRepository.findAll();
		model.addAttribute("listaProdutos", produtos);
		return "home";
	}
	
	@GetMapping("/{status}")
	public String findStatus(@PathVariable String status, Model model) {
		List<Produto> produtos = produtoRepository.findByStatus(StatusPedido.valueOf(status.toUpperCase()));
		model.addAttribute("listaProdutos", produtos);
		model.addAttribute("status", status);
		return "home";
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public String notFound(Model model) {
		return "redirect:/home";
	}
	

}
