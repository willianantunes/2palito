/**
 * 
 */
package br.com.aqlbras.catmovshop.mobile.android.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

import org.joda.time.DateTime;

/**
 * @author Almeida
 * 
 */
public class Pedido implements Serializable {

	private Long id;
	private boolean favorito;
	private PedidoType status;
	private String codSolicitacao;
	private DateTime dataCadastro;
	private DateTime dataUltimaAlteracao;
	private Usuario usuario;
	private Fornecedor fornecedor;
	private Collection<ItemProduto> itemProdutos;

	/**
	 * @param status
	 * @param favorito
	 * @param codSolicitacao
	 * @param itens
	 */

	public Pedido() {
		super();
		id = 454L;
	}

	public Pedido(boolean favorito, PedidoType status, String codSolicitacao,
			DateTime dataCadastro, DateTime dataUltimaAlteracao,
			Usuario usuario, Fornecedor fornecedor) {
		super();
		this.favorito = favorito;
		this.status = status;
		this.codSolicitacao = codSolicitacao;
		this.dataCadastro = dataCadastro;
		this.dataUltimaAlteracao = dataUltimaAlteracao;
		this.usuario = usuario;
		this.fornecedor = fornecedor;
	}

	public Pedido(boolean favorito, PedidoType status, String codSolicitacao,
			DateTime dataCadastro, DateTime dataUltimaAlteracao,
			Usuario usuario, Fornecedor fornecedor,
			Collection<ItemProduto> itemProdutos) {
		super();
		this.favorito = favorito;
		this.status = status;
		this.codSolicitacao = codSolicitacao;
		this.dataCadastro = dataCadastro;
		this.dataUltimaAlteracao = dataUltimaAlteracao;
		this.usuario = usuario;
		this.fornecedor = fornecedor;
		this.itemProdutos = itemProdutos;
	}

	public DateTime getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(DateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public DateTime getDataUltimaAlteracao() {
		return dataUltimaAlteracao;
	}

	public void setDataUltimaAlteracao(DateTime dataUltimaAlteracao) {
		this.dataUltimaAlteracao = dataUltimaAlteracao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public void setItemProdutos(Set<ItemProduto> itemProdutos) {
		this.itemProdutos = itemProdutos;
	}

	public PedidoType getStatus() {
		return status;
	}

	public void setStatus(PedidoType status) {
		this.status = status;
	}

	/**
	 * @return the favorito
	 */
	public boolean isFavorito() {
		return favorito;
	}

	/**
	 * @param favorito
	 *            the favorito to set
	 */
	public void setFavorito(boolean favorito) {
		this.favorito = favorito;
	}

	/**
	 * @return the codSolicitacao
	 */
	public String getCodSolicitacao() {
		return codSolicitacao;
	}

	/**
	 * @param codSolicitacao
	 *            the codSolicitacao to set
	 */
	public void setCodSolicitacao(String codSolicitacao) {
		this.codSolicitacao = codSolicitacao;
	}

	public Collection<ItemProduto> getItemProdutos() {
		return itemProdutos;
	}

	public void setItemProdutos(Collection<ItemProduto> itemProdutos) {
		this.itemProdutos = itemProdutos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}



}