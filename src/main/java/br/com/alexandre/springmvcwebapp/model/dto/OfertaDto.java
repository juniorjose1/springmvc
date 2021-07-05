package br.com.alexandre.springmvcwebapp.model.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import br.com.alexandre.springmvcwebapp.model.Oferta;

public class OfertaDto {
	
	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	@Pattern(regexp = "^\\d+(\\.\\d+{2})?$")// padrao ex 12312.33 ou 12312
	@NotNull
	private String valor;
	
	private String comentario;
	
	@Pattern(regexp = "^\\d{2}/\\d{2}/\\d{4}$")// padrao ex 10/07/2021
	@NotNull
	private String dataDeEntrega;
	
	private Long pedidoId;

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public String getDataDeEntrega() {
		return dataDeEntrega;
	}

	public void setDataDeEntrega(String dataDeEntrega) {
		this.dataDeEntrega = dataDeEntrega;
	}

	public Long getPedidoId() {
		return pedidoId;
	}

	public void setPedidoId(Long pedidoId) {
		this.pedidoId = pedidoId;
	}

	public Oferta toOferta() {
		Oferta oferta = new Oferta();

		oferta.setComentario(this.getComentario());
		oferta.setDataEntrega(LocalDate.parse(dataDeEntrega, FORMATTER));
		oferta.setValor(new BigDecimal(valor));
		
		return oferta;

	}

}
