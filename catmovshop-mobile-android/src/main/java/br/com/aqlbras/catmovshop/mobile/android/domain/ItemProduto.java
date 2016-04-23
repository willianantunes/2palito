/**
 * 
 */
package br.com.aqlbras.catmovshop.mobile.android.domain;

import java.io.Serializable;

/**
 * @author Almeida
 *
 */
public class ItemProduto implements Serializable{
	private String id;
	private Double preco;
	private int quantidade;
	private String nome;
	private String descricao;	
	private String data;
	private String imagem;
	private Produto Produto;
	
	/**
	 * @param preco
	 * @param quantidade
	 * @param nome
	 * @param descricao
	 * @param data
	 * @param imagem
	 * @param Produto
	 */
	public ItemProduto(Double preco, int quantidade, String nome,
			String descricao, String data, String imagem, Produto idProduto) {
		super();
		this.preco = preco;
		this.quantidade = quantidade;
		this.nome = nome;
		this.descricao = descricao;
		this.data = data;
		this.imagem = imagem;
		this.Produto = idProduto;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return the preco
	 */
	public Double getPreco() {
		return preco;
	}

	/**
	 * @return the quantidade
	 */
	public int getQuantidade() {
		return quantidade;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @return the data
	 */
	public String getData() {
		return data;
	}

	/**
	 * @return the imagem
	 */
	public String getImagem() {
		return imagem;
	}

	/**
	 * @return the Produto
	 */
	public Produto getProduto() {
		return Produto;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Produto == null) ? 0 : Produto.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemProduto other = (ItemProduto) obj;
		if (Produto == null) {
			if (other.Produto != null)
				return false;
		} else if (!Produto.equals(other.Produto))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
}
