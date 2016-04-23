package br.com.aqlbras.catmovshop.mobile.android.model;

import java.util.Collection;

import org.joda.time.DateTime;


public class Pedido
{
	private PedidoType status;
	private String codSolicitacao;
	private DateTime dataCadastro;
	private DateTime dataUltimaAlteracao;	
	private Usuario usuario;
	private Fornecedor fornecedor;	
	private Collection<ItemProduto> itemProdutos;
}
