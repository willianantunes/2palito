/**
 * 
 */
package br.com.aqlbras.catmovshop.mobile.android.model;

import java.io.Serializable;
import java.util.Collection;

import org.joda.time.DateTime;

public class Fornecedor implements Serializable {

	private Long id;
	private String razaoSocial;
	private String cnpj;
	private String descricao;
	private String localizacao;
	private String numeroShop;
	private DateTime dataCadastro;
	private boolean ativo;
	private String nomeImagem;
	private PerfilFornecedor perfilFornecedor;
	private Collection<Produto> produtos;

	public Fornecedor() {
	}

	public Fornecedor(Long id, String razaoSocial, String cnpj,
			String descricao, boolean ativo, String nomeImagem) {
		this.id = id;
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
		this.descricao = descricao;
		this.ativo = ativo;
		this.nomeImagem = nomeImagem;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	public String getNumeroShop() {
		return numeroShop;
	}

	public void setNumeroShop(String numeroShop) {
		this.numeroShop = numeroShop;
	}

	public PerfilFornecedor getPerfilFornecedor() {
		return perfilFornecedor;
	}

	public void setPerfilFornecedor(PerfilFornecedor perfilFornecedor) {
		this.perfilFornecedor = perfilFornecedor;
	}

	public Collection<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(Collection<Produto> produtos) {
		this.produtos = produtos;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public DateTime getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(DateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getNomeImagem() {
		return nomeImagem;
	}

	public void setNomeImagem(String nomeImagem) {
		this.nomeImagem = nomeImagem;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

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
