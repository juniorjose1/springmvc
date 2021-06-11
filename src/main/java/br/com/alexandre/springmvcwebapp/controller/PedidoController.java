package br.com.alexandre.springmvcwebapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alexandre.springmvcwebapp.model.Produto;
import br.com.alexandre.springmvcwebapp.model.dto.ProdutoDto;
import br.com.alexandre.springmvcwebapp.repository.ProdutoRepository;

@Controller
@RequestMapping("pedido")
public class PedidoController {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@GetMapping
	public String form(ProdutoDto produtoDto) {
		return "pedido/formulario";
	}
	
	@PostMapping("novo")
	public String cadastrarPedido(ProdutoDto produtoDto) {
		
		Produto produto = produtoDto.toProduto();
		
		produtoRepository.save(produto);
		
		return "redirect:/home";
	}

}