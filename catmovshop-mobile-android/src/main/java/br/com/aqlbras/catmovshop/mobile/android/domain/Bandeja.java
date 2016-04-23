package br.com.aqlbras.catmovshop.mobile.android.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author Almeida
 * 
 */
public class Bandeja implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7924113091824023561L;
	private String id;
	private String status;
	private boolean favorito;
	private Map<Fornecedor,Set<ItemProduto>> mapaItensFornecedor; 

	/**
	 * @param status
	 * @param favorito
	 * @param codSolicitacao
	 * @param itens
	 */

	public Bandeja(String status, boolean favorito) {
		super();
		this.status = status;
		this.favorito = favorito;
	}


	



	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}






	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}






	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}






	/**
	 * @return the favorito
	 */
	public boolean isFavorito() {
		return favorito;
	}






	/**
	 * @return the mapaItensFornecedor
	 */
	public Map<Fornecedor, Set<ItemProduto>> getMapaItensFornecedor() {
		return mapaItensFornecedor;
	}






	// METODOS ESPECIFICOS
	public void gerarRelatorio() {

	}

	public void realizarPedido() {
			
			
		
	}

	public void cancelarPedido() {

	}
	
	public void adicionarItem(ItemProduto itemProduto) {
			if (mapaItensFornecedor == null) {
				mapaItensFornecedor = new TreeMap <Fornecedor, Set<ItemProduto>>();
				Set<ItemProduto> itensProduto = new HashSet <ItemProduto>();
				itensProduto.add(itemProduto);
				
				mapaItensFornecedor.put(itemProduto.getProduto().getFornecedor(), itensProduto);
			}else{
				if (mapaItensFornecedor.containsKey(itemProduto.getProduto().getFornecedor())){
					mapaItensFornecedor.get(itemProduto.getProduto().getFornecedor()).add(itemProduto);
				}else{
					Set<ItemProduto> itensProduto = new HashSet <ItemProduto>();
					itensProduto.add(itemProduto);
					
					mapaItensFornecedor.put(itemProduto.getProduto().getFornecedor(), itensProduto);
				}
			}
	}
	
	public void removerItem(ItemProduto itemProduto) {
		if (mapaItensFornecedor.containsKey(itemProduto.getProduto().getFornecedor())){
			mapaItensFornecedor.get(itemProduto.getProduto().getFornecedor()).remove(itemProduto);
		}
	}
}
