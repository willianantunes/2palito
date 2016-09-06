package br.com.aqlbras.catmovshop.mobile.android.model;

import java.io.Serializable;

public class ObjetoTransferencia implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8492552925019339472L;
	private Pedido pedido;
	private Bandeja bandeja;
	private Fornecedor fornecedor;
	private Produto produtoEscolhido;
	private ItemProduto ultimoItemEscolhido;

	public ObjetoTransferencia(Pedido pedido, Bandeja bandeja) {
		super();
		this.pedido = pedido;
		this.bandeja = bandeja;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public Bandeja getBandeja() {
		return bandeja;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public void setBandeja(Bandeja bandeja) {
		this.bandeja = bandeja;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public Produto getProdutoEscolhido() {
		return produtoEscolhido;
	}

	public void setProdutoEscolhido(Produto produtoEscolhido) {
		this.produtoEscolhido = produtoEscolhido;
	}

	public ItemProduto getUltimoItemEscolhido() {
		return ultimoItemEscolhido;
	}

	public void setUltimoItemEscolhido(ItemProduto ultimoItemEscolhido) {
		this.ultimoItemEscolhido = ultimoItemEscolhido;
	}

}
