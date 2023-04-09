package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


//CLASSE MODELO OU DATA = TABELA/ENTIDADE DE DADOS
@Entity
@Table(name ="supermercado")

public class Supermercado {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	
	public String getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}

	@Column(nullable = false)
	private String produto;
	
	@Column(nullable = false)
	private Double preco;	
		
	@Column(nullable = false)
	private String fornecedor;

}
