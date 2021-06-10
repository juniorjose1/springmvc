package br.com.alexandre.springmvcwebapp.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "produtos")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private BigDecimal valor;
	private LocalDate data;
	private String linkProduto;
	private String descricao;
	private String linkImagem;

	public Produto() {
	}

	public Produto(String nome, BigDecimal valor, String linkProduto, String descricao, String linkImagem) {
		this.nome = nome;
		this.valor = valor;
		this.data = LocalDate.now();
		this.linkProduto = linkProduto;
		this.descricao = descricao;
		this.linkImagem = linkImagem;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public LocalDate getData() {
		return data;
	}

	public String getLinkProduto() {
		return linkProduto;
	}

	public void setLinkProduto(String linkProduto) {
		this.linkProduto = linkProduto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getLinkImagem() {
		return linkImagem;
	}

	public void setLinkImagem(String linkImagem) {
		this.linkImagem = linkImagem;
	}

}
