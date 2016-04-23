package br.com.aqlbras.catmovshop.mobile.android.model;

import java.util.Collection;

import org.joda.time.DateTime;

public class Produto
{
	private String nome;
	private float preco;
	private String descricao;
	private DateTime dataCadastro;
	private String nomeImagem;
	private boolean ativo;	
	private Fornecedor fornecedor;
	private Collection<ItemProduto> ItemProdutos;
}
