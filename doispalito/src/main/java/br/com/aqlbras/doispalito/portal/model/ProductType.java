package br.com.aqlbras.doispalito.portal.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.aqlbras.doispalito.portal.model.common.AbstractEntity;

@Entity
public class ProductType extends AbstractEntity
{
	@NotNull
	@Length(max=45)
	private String name;
	
	@ManyToMany(mappedBy="productTypes", targetEntity=Product.class, fetch=FetchType.LAZY)
	private Collection<Product> products;
	
	@NotNull
	@ManyToOne(optional=false, fetch=FetchType.LAZY)
	private Establishment establishment;

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}
}
