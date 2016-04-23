package br.com.aqlbras.doispalito.portal.model.granulation;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public final class Address 
{

	@Id
	@Column(name = "id_endereco")
	@Access(AccessType.FIELD)
	private int id;

	@NotNull
	@Column(name = "numero_endereco")
	private final String numero;

	@Column(name = "complemento_endereco")
	private final String complemento;

	@Column(name = "ponto_referencia_endereco")
	private final String pontoReferencia;

	@ManyToOne
	@NotNull
	@JoinColumn(name = "id_logradouro", referencedColumnName = "id_logradouro" )
	 private final Location logradouro;

	/**
	 * Private Hibernate constructor
	 */
	@SuppressWarnings("unused")
	private Address() 
	{
		this.logradouro = null;
		this.numero = null;
		this.complemento = null;
		this.pontoReferencia = null;
	}

	public Address(Location logradouro, String numero, String complemento,String pontoReferencia) 
	{
		super();
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.pontoReferencia = pontoReferencia;
	}

	public Location getLogradouro() 
	{
		return logradouro;
	}

	public String getNumero() 
	{
		return numero;
	}

	public String getComplemento() 
	{
		return complemento;
	}

	public String getPontoReferencia() 
	{
		return pontoReferencia;
	}

	public int getId() 
	{
		return id;
	}
}
