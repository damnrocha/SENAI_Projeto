package com.br.senai.projetoFinal.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class EstoqueModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;


	
	private String datEntrada;
	private String datSaida;
	private String nomeFornecedor;
	private String nomeProduto;
	private double preco;
	private Integer quantidade;
	private String desconto;
	private String urlImgm;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getDatEntrada() {
		return datEntrada;
	}
	public void setDatEntrada(String datEntrada) {
		this.datEntrada = datEntrada;
	}
	public String getDatSaida() {
		return datSaida;
	}
	public void setDatSaida(String datSaida) {
		this.datSaida = datSaida;
	}
	public String getNomeFornecedor() {
		return nomeFornecedor;
	}
	public void setNomeFornecedor(String nomeFornecedor) {
		this.nomeFornecedor = nomeFornecedor;
	}
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public String getDesconto() {
		return desconto;
	}
	public void setDesconto(String desconto) {
		this.desconto = desconto;
	}
	public String getUrlImgm() {
		return urlImgm;
	}
	public void setUrlImgm(String urlImgm) {
		this.urlImgm = urlImgm;
	}
	
	
	
	
}


