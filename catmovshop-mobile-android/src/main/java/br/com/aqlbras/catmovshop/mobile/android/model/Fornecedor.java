package br.com.aqlbras.catmovshop.mobile.android.model;

import java.util.Collection;

import org.joda.time.DateTime;

public class Fornecedor
{
	private String razaoSocial;	
	private String cnpj;
	private String descricao;
	private String localizacao;
	private String numeroShop;
	private DateTime dataCadastro;	
	private boolean ativo;
	private String nomeImagem;
	private Collection<Produto> produtos;
	private Collection<Pedido> pedidos;
}
