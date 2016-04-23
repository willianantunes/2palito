package br.com.aqlbras.doispalito.portal.model.granulation;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public final class Location 
{
	public enum TipoLogradouro 
	{
		AVENIDA, PRACA, RUA
	}

	@Id
	@Column(name = "id_logradouro")
	@Access(AccessType.FIELD)
	private final int id;

	@Access(AccessType.FIELD)
	@Column(name = "descricao_logradouro", length = 60, nullable = false)
	private final String descricao;

	@Access(AccessType.FIELD)
	private final String cep;

	@Enumerated(EnumType.STRING)
	@Access(AccessType.FIELD)
	@Column(name = "tipo_logradouro", nullable = false, length = 12)
	private final TipoLogradouro tipoLogradouro;

	@ManyToOne
	@Access(AccessType.FIELD)
	@JoinColumn(name = "id_bairro", referencedColumnName = "id_bairro", nullable = false)
	private final District bairro;

	/**
	 * Private Hibernate constructor
	 */
	@SuppressWarnings("unused")
	private Location() 
	{
		id = 0;
		descricao = null;
		bairro = null;
		cep = null;
		tipoLogradouro = null;
	}

	public Location(String descricao, TipoLogradouro tipoLogradouro, District bairro, String cep) 
	{
		super();
		// TODO Assumir invariantes
		this.id = 0;// hibernate vai definir esse valor
		this.descricao = descricao;
		this.tipoLogradouro = tipoLogradouro;
		this.bairro = bairro;
		this.cep = cep;
	}

	public int getId() 
	{
		return id;
	}

	public String getDescricao() 
	{
		return descricao;
	}

	public District getBairro() 
	{
		return bairro;
	}

	public TipoLogradouro getTipoLogradouro() 
	{
		return tipoLogradouro;
	}

	public String getCep() 
	{
		return cep;
	}

}
