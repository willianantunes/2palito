/**
 * 
 */
package br.com.aqlbras.catmovshop.mobile.android.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import br.com.aqlbras.catmovshop.mobile.android.adapters.ItemProdutoAdapter;

/**
 * @author Almeida
 * 
 */
public class Pedido implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7924113091824023561L;
	private String id;
	private String status;
	private boolean favorito;
	private String codSolicitacao;
	private Set<ItemProduto> itens;

	/**
	 * @param status
	 * @param favorito
	 * @param codSolicitacao
	 * @param itens
	 */

	public Pedido(String status, boolean favorito, String codSolicitacao) {
		super();
		this.status = status;
		this.favorito = favorito;
		this.codSolicitacao = codSolicitacao;
	}


	// GETTERS AND SETTERS
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
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

	/**
	 * @return the itens
	 */
	public Set<ItemProduto> getItens() {
		return itens;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	// METODOS ESPECIFICOS
	public void gerarRelatorio() {

	}

	public void realizarPedido() {
			
			
		
	}

	public void cancelarPedido() {

	}

}
