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
public class Fornecedor implements Serializable{
	private String id;	
	private String razaoSocial;
	private String cnpj;
	private String descricao;
	private String localizacao;
	private String numeroShop;
	private String imagem;


	/**
	 * @param razaoSocial
	 * @param cnpj
	 * @param descricao
	 * @param localizacao
	 * @param numeroShop
	 * @param imagem
	 */
	public Fornecedor(String razaoSocial, String cnpj, String descricao,
			String localizacao, String numeroShop, String imagem) {
		super();
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
		this.descricao = descricao;
		this.localizacao = localizacao;
		this.numeroShop = numeroShop;
		this.imagem = imagem;
	}

	public Fornecedor() {
		// TODO Auto-generated constructor stub
	}

	
	//GETTERS AND SETTERS 
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
	 * @return the razaoSocial
	 */
	public String getRazaoSocial() {
		return razaoSocial;
	}

	/**
	 * @param razaoSocial the razaoSocial to set
	 */
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	/**
	 * @return the cnpj
	 */
	public String getCnpj() {
		return cnpj;
	}

	/**
	 * @param cnpj the cnpj to set
	 */
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
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
	 * @return the localizacao
	 */
	public String getLocalizacao() {
		return localizacao;
	}

	/**
	 * @param localizacao the localizacao to set
	 */
	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	/**
	 * @return the numeroShop
	 */
	public String getNumeroShop() {
		return numeroShop;
	}

	/**
	 * @param numeroShop the numeroShop to set
	 */
	public void setNumeroShop(String numeroShop) {
		this.numeroShop = numeroShop;
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
		Fornecedor other = (Fornecedor) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
