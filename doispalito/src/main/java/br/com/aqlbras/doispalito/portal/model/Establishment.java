package br.com.aqlbras.doispalito.portal.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Null;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Length;
import org.joda.time.DateTime;

import br.com.aqlbras.doispalito.portal.model.common.AbstractEntity;


@Entity
/**
 * Prospecção: Do jeito que a classe foi modelada, se um Brand tiver várias localidades, e essas, por sua vez, tiverem os mesmo 
 * produtos, teríamos redundância de dados, portanto, seria melhor passar os produtos para a classe Brand e criar uma nova classe para 
 * produtos específicos para cada localidade.
 * @author Willian Antunes / Bruno Alves
 * @version 1.0.0
 */
public class Establishment extends AbstractEntity
{
	@Column(nullable=true)
	@Type(type= "org.jadira.usertype.dateandtime.joda.PersistentDateTime")	
	private DateTime registerDate;
	
	@Column(nullable = false, columnDefinition = "BIT DEFAULT 1", length = 1, insertable=false, updatable=true)
	private boolean active;
	
	@OneToOne(optional=false, cascade=CascadeType.ALL)
	private EstablishmentProfile establishmentProfile;
	
	@OneToMany(mappedBy="establishment", fetch=FetchType.LAZY)
	private Collection<Product> products;
	
	@ManyToMany(cascade=CascadeType.ALL)
	private Collection<Phone> phones;
	
	@OneToMany(mappedBy = "establishment", cascade=CascadeType.ALL)
	private Collection<User> users;
	
	@Null
	@OneToMany(mappedBy="establishment", cascade=CascadeType.ALL)
	private Collection<Recommendation> recommendation;
	
	@OneToMany(mappedBy="establishment", fetch=FetchType.LAZY)
	private Collection<ProductType> productTypes;
	
	@OneToOne(optional=false)
	private CommercialRoom commercialRoom;
	
	@ManyToOne(optional=false, fetch=FetchType.EAGER)
	private Brand brand;

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

	public EstablishmentProfile getEstablishmentProfile() {
		return establishmentProfile;
	}

	public void setEstablishmentProfile(EstablishmentProfile establishmentProfile) {
		this.establishmentProfile = establishmentProfile;
	}

	public Collection<Product> getProducts() {
		return products;
	}

	public void setProducts(Collection<Product> products) {
		this.products = products;
	}

	public Collection<Phone> getPhones() {
		return phones;
	}

	public void setPhones(Collection<Phone> phones) {
		this.phones = phones;
	}

	public Collection<User> getUsers() {
		return users;
	}

	public void setUsers(Collection<User> users) {
		this.users = users;
	}

	public Collection<Recommendation> getRecommendation() {
		return recommendation;
	}

	public void setRecommendation(Collection<Recommendation> recommendation) {
		this.recommendation = recommendation;
	}

	public Collection<ProductType> getProductTypes() {
		return productTypes;
	}

	public void setProductTypes(Collection<ProductType> productTypes) {
		this.productTypes = productTypes;
	}

	public CommercialRoom getCommercialRoom() {
		return commercialRoom;
	}

	public void setCommercialRoom(CommercialRoom commercialRoom) {
		this.commercialRoom = commercialRoom;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}
}
