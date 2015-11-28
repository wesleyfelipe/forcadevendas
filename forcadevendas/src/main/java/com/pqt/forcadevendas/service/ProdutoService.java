package com.pqt.forcadevendas.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pqt.forcadevendas.dao.IProdutoDAO;
import com.pqt.forcadevendas.entity.ImagemProduto;
import com.pqt.forcadevendas.entity.Produto;
import com.pqt.forcadevendas.entity.to.ProdutoDTO;
import com.pqt.forcadevendas.entity.to.ProdutoDadosBasicosDTO;

@Service
public class ProdutoService implements IProdutoService {

	@Autowired
	private IProdutoDAO dao;

	@Override
	public List<ProdutoDadosBasicosDTO> listProdutos() {
		List<Produto> produtos = dao.listProdutos();
		List<ProdutoDadosBasicosDTO> dtos = new ArrayList<ProdutoDadosBasicosDTO>();
		for (Produto produto : produtos) {
			dtos.add(new ProdutoDadosBasicosDTO(produto.getId(), produto.getModelo().getNome(), produto.getPreco(),
					produto.getPrecoPromocao(), produto.getImagemPrincipal(), produto.getCor(),
					produto.getModelo().getMarca().getNome()));
		}
		return dtos;
	}

	@Override
	public ProdutoDTO getProduto(Integer id) {
		Produto produto = dao.getProduto(id);
		if(produto == null)
			throw new NotFoundException("Produto com identificador " + id + " não existe.");
		return buildProdutoDtoFromProduto(produto);
	}
	
	private ProdutoDTO buildProdutoDtoFromProduto(Produto produto){
		ProdutoDTO produtoDto = new ProdutoDTO();
		produtoDto.setCategoria(produto.getModelo().getCategoria().getNome());
		produtoDto.setColecao(produto.getModelo().getColecao().getNome());
		produtoDto.setCor(produto.getCor());
		produtoDto.setDepartamento(produto.getModelo().getDepartamento().getNome());
		produtoDto.setId(produto.getId());
		produtoDto.setImagem(produto.getImagemPrincipal());
		for (ImagemProduto imagemProduto : produto.getImagemProdutos()) {
			produtoDto.getImagensAdicionais().add(imagemProduto.getImagem());
		}
		produtoDto.setMarca(produto.getModelo().getMarca().getNome());
		produtoDto.setNomeModelo(produto.getModelo().getNome());
		produtoDto.setPreco(produto.getPreco());
		produtoDto.setPrecoPromocional(produto.getPrecoPromocao());
		
		return produtoDto;
	}
}
