package br.com.alexandre.springmvcwebapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
		
		Sort sort = Sort.by("data").descending();
		
		PageRequest page = PageRequest.of(0, 5, sort);
		
		List<Produto> produtos = produtoRepository.findByStatus(StatusPedido.ENTREGUE, page);
		model.addAttribute("listaProdutos", produtos);
		return "home";
	}
	

}
