package br.com.aqlbras.doispalito.portal.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.aqlbras.doispalito.portal.model.common.AbstractEntity;

@Entity
public class ProductItem extends AbstractEntity
{
	@NotNull
	@Length(max=45)
	private String name;
	
	@NotNull
	@Column(precision=10, scale=2)	
	private double price;
	
	@NotNull
	private int quantity;
	
	@NotNull
	@Length(max=400)	
	private String description;
	
	@Length(max=100)
	private String imageLink;	
	
	// Não é possível deletar um produto por causa da restrição do ID
	@ManyToOne(optional=false)
	private Product product;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageLink() {
		return imageLink;
	}

	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}
