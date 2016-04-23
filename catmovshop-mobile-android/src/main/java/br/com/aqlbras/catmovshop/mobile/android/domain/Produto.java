/**
 * 
 */
package br.com.aqlbras.catmovshop.mobile.android.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Almeida
 *
 */
public class Produto implements Serializable{
	private String id;
	private Fornecedor fornecedor ;
	private String nome;
	private Double preco;
	private String descricao;	
	public String imagem;
	private String data;

	
	
	/**
	 * 
	 */
	public Produto() {
		super();
	}

	/**
	 * @param id
	 * @param fornecedor
	 * @param nome
	 * @param preco
	 * @param descricao
	 * @param imagem
	 * @param data
	 */
	public Produto(String id, Fornecedor fornecedor, String nome, Double preco,
			String descricao, String imagem, String data) {
		super();
		this.id = id;
		this.fornecedor = fornecedor;
		this.nome = nome;
		this.preco = preco;
		this.descricao = descricao;
		this.imagem = imagem;
		this.data = data;
	}
	

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}


	/**
	 * @return the fornecedor
	 */
	public Fornecedor getFornecedor() {
		return fornecedor;
	}


	/**
	 * @param fornecedor the fornecedor to set
	 */
	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}


	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}


	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}


	/**
	 * @return the preco
	 */
	public Double getPreco() {
		return preco;
	}


	/**
	 * @param preco the preco to set
	 */
	public void setPreco(Double preco) {
		this.preco = preco;
	}


	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}


	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	/**
	 * @return the imagem
	 */
	public String getImagem() {
		return imagem;
	}


	/**
	 * @param imagem the imagem to set
	 */
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}


	/**
	 * @return the data
	 */
	public String getData() {
		return data;
	}


	/**
	 * @param data the data to set
	 */
	public void setData(String data) {
		this.data = data;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
	
}
