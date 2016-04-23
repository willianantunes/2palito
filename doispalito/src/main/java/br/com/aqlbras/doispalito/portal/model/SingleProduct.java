package br.com.aqlbras.doispalito.portal.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

@Entity
public class SingleProduct extends Product 
{
	@ManyToMany(cascade=CascadeType.ALL, targetEntity=Ingredient.class)	
	private Collection<Ingredient> ingredients;
		
	/*
	@ManyToMany(cascade=CascadeType.ALL)
	private Collection<ComboProduct> comboProducts;*/	
	
	public SingleProduct()
	{
		
	}
	
	public SingleProduct(Long id)
	{
		super.setId(id);
	}
}
