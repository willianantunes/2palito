/**
 * 
 */
package br.com.aqlbras.catmovshop.mobile.android.model;

import java.io.Serializable;

/**
 * @author Almeida
 * 
 */
public class ItemProduto implements Serializable {

	private String id;
	private String nome;
	private float preco;
	private int quantidade;
	private String descricao;
	private String nomeImagem;
	private Produto Produto;

	/**
	 * @param preco
	 * @param quantidade
	 * @param nome
	 * @param descricao
	 * @param data
	 * @param nomeImagem
	 * @param Produto
	 */
	public ItemProduto(int quantidade, Produto produto) {
		super();
		this.preco = produto.getPreco();
		this.quantidade = quantidade;
		this.nome = produto.getNome();
		this.descricao = produto.getDescricao();
		this.nomeImagem = produto.getNomeImagem();
		this.Produto = produto;
	}

	public String getNomeImagem() {
		return nomeImagem;
	}

	public void setNomeImagem(String nomeImagem) {
		this.nomeImagem = nomeImagem;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public void setProduto(Produto produto) {
		Produto = produto;
	}

	public ItemProduto() {
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
	public float getPreco() {
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
	 * @return the imagem
	 */
	public String getImagem() {
		return nomeImagem;
	}

	/**
	 * @return the Produto
	 */
	public Produto getProduto() {
		return Produto;
	}

	/*
	 * (non-Javadoc)
	 * 
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

	/*
	 * (non-Javadoc)
	 * 
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
