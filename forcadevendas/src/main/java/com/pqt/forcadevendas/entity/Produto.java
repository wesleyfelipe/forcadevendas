package com.pqt.forcadevendas.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * The persistent class for the produto database table.
 * 
 */
@Entity
@Table(schema = "FDV_ONLINE")
public class Produto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String cor;

	@Column(name = "imagem_principal")
	private String imagemPrincipal;

	private BigDecimal preco;

	@Column(name = "preco_promocao")
	private BigDecimal precoPromocao;

	// bi-directional many-to-one association to ImagemProduto
	@OneToMany(mappedBy = "produto")
	private List<ImagemProduto> imagemProdutos;

	// bi-directional many-to-one association to Modelo
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idmodelo")
	private Modelo modelo;

	public Produto() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCor() {
		return this.cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getImagemPrincipal() {
		return this.imagemPrincipal;
	}

	public void setImagemPrincipal(String imagemPrincipal) {
		this.imagemPrincipal = imagemPrincipal;
	}

	public BigDecimal getPreco() {
		return this.preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public BigDecimal getPrecoPromocao() {
		return this.precoPromocao;
	}

	public void setPrecoPromocao(BigDecimal precoPromocao) {
		this.precoPromocao = precoPromocao;
	}

	public List<ImagemProduto> getImagemProdutos() {
		return this.imagemProdutos;
	}

	public void setImagemProdutos(List<ImagemProduto> imagemProdutos) {
		this.imagemProdutos = imagemProdutos;
	}

	public ImagemProduto addImagemProduto(ImagemProduto imagemProduto) {
		getImagemProdutos().add(imagemProduto);
		imagemProduto.setProduto(this);

		return imagemProduto;
	}

	public ImagemProduto removeImagemProduto(ImagemProduto imagemProduto) {
		getImagemProdutos().remove(imagemProduto);
		imagemProduto.setProduto(null);

		return imagemProduto;
	}

	public Modelo getModelo() {
		return this.modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}
	

	public BigDecimal getPrecoValido(){
		return precoPromocao != null ? precoPromocao : preco;
	}

}