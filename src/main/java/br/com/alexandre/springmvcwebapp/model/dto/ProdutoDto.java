package br.com.alexandre.springmvcwebapp.model.dto;

import br.com.alexandre.springmvcwebapp.model.Produto;

public class ProdutoDto {
	
	private String nome;
	private String urlProduto;
	private String urlImagem;
	private String descricao;
	
	public ProdutoDto(String nome, String urlProduto, String urlImagem, String descricao) {
		this.nome = nome;
		this.urlProduto = urlProduto;
		this.urlImagem = urlImagem;
		this.descricao = descricao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUrlProduto() {
		return urlProduto;
	}

	public void setUrlProduto(String urlProduto) {
		this.urlProduto = urlProduto;
	}

	public String getUrlImagem() {
		return urlImagem;
	}

	public void setUrlImagem(String urlImagem) {
		this.urlImagem = urlImagem;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Produto toProduto() {
		Produto produto = new Produto();
		produto.setNome(this.getNome());
		produto.setDescricao(this.getDescricao());
		produto.setLinkImagem(this.getUrlImagem());
		produto.setLinkProduto(this.getUrlProduto());
		
		return produto;
	}

}
