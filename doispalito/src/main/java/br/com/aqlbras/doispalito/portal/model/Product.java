package br.com.aqlbras.doispalito.portal.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Length;
import org.joda.time.DateTime;

import br.com.aqlbras.doispalito.portal.model.common.AbstractEntity;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Product extends AbstractEntity
{
	@NotNull
	@Length(max=45)
	private String name;
	
	@NotNull
	@Column(precision=10, scale=2)	
	private double price;
	
	@NotNull
	@Length(max=400)	
	private String description;
	
	@Length(max=100)
	private String imageLink;
		
	@Column(nullable=false)
	@Type(type= "org.jadira.usertype.dateandtime.joda.PersistentDateTime")		
	private DateTime registerDate;
	
	@Column(nullable = false, columnDefinition = "BIT DEFAULT 1", length=1)
	private boolean active;
	
	@ManyToOne(optional=false, fetch=FetchType.LAZY)
	private Establishment establishment;
	
	@ManyToMany(targetEntity=ProductType.class)
	private Collection<ProductType> productTypes;
	
	@Null
	@OneToMany(mappedBy="product")
	private Collection<Recommendation> recommendation;

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

	public DateTime getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(DateTime registerDate) {
		this.registerDate = registerDate;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Establishment getEstablishment() {
		return establishment;
	}

	public void setEstablishment(Establishment establishment) {
		this.establishment = establishment;
	}

	public Collection<ProductType> getProductTypes() {
		return productTypes;
	}

	public void setProductTypes(Collection<ProductType> productTypes) {
		this.productTypes = productTypes;
	}

	public Collection<Recommendation> getRecommendation() {
		return recommendation;
	}

	public void setRecommendation(Collection<Recommendation> recommendation) {
		this.recommendation = recommendation;
	}
}