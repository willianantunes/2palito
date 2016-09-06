package br.com.aqlbras.catmovshop.mobile.android.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.joda.time.DateTime;

import br.com.aqlbras.catmovshop.mobile.android.integracao.PedidoIntegracao;

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
	private Map<Fornecedor, Set<ItemProduto>> mapaItensFornecedor;

	/**
	 * @param status
	 * @param favorito
	 * @param codSolicitacao
	 * @param itens
	 */

	public Bandeja(String status, boolean favorito) {
		super();
		mapaItensFornecedor = new HashMap<Fornecedor, Set<ItemProduto>>();
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

	public void setId(String id) {
		this.id = id;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setFavorito(boolean favorito) {
		this.favorito = favorito;
	}

	public void setMapaItensFornecedor(
			Map<Fornecedor, Set<ItemProduto>> mapaItensFornecedor) {
		this.mapaItensFornecedor = mapaItensFornecedor;
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

		List<Pedido> listaPedidos = new LinkedList<Pedido>();

		for (Fornecedor key : mapaItensFornecedor.keySet()) {

			Pedido pedido = new Pedido(false, PedidoType.EM_ANALISE, "6", DateTime.now(),
					DateTime.now(), null, key,
					mapaItensFornecedor.get(key));

			listaPedidos.add(pedido);
		}

		dispacharPedidos(listaPedidos);
	}

	private void dispacharPedidos(List<Pedido> pedidos) {
		new PedidoIntegracao().dispacharPedidos(pedidos);
	}

	public void cancelarPedido() {

	}

	public void adicionarItem(ItemProduto itemProduto) {

		Fornecedor fornecedorProduto = itemProduto.getProduto().getFornecedor();

		if (mapaItensFornecedor.containsKey(fornecedorProduto)) {
			mapaItensFornecedor.get(fornecedorProduto).remove(itemProduto);
			mapaItensFornecedor.get(fornecedorProduto).add(itemProduto);
		} else {
			Set<ItemProduto> itensProduto = new HashSet<ItemProduto>();
			itensProduto.add(itemProduto);

			mapaItensFornecedor.put(itemProduto.getProduto().getFornecedor(),
					itensProduto);
		}

	}

	public void removerItem(ItemProduto itemProduto) {
		if (mapaItensFornecedor.containsKey(itemProduto.getProduto()
				.getFornecedor())) {
			mapaItensFornecedor.get(itemProduto.getProduto().getFornecedor())
					.remove(itemProduto);
		}
	}
}
