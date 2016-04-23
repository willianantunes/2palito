package br.com.aqlbras.doispalito.portal.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

@Entity
public class ComboProduct extends Product
{
	@ManyToMany(targetEntity=SingleProduct.class)
	private Collection<SingleProduct> singleProducts;
	/*
	@ManyToMany(mappedBy="comboProducts")
	private Collection<SingleProduct> singleProducts;*/

	public ComboProduct()
	{
		
	}
	
	public ComboProduct(Long id)
	{
		super.setId(id);
	}
}
