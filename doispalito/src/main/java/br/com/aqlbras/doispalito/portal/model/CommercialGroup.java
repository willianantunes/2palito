package br.com.aqlbras.doispalito.portal.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.aqlbras.doispalito.portal.model.common.AbstractEntity;
import br.com.aqlbras.doispalito.portal.model.granulation.Address;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class CommercialGroup extends AbstractEntity
{
	@NotNull
	@Length(max=45)	
	private String name;
	
	@NotNull
	@Length(max=400)	
	private String description;
	
	@Length(max=100)
	private String imageLink;
	
	@NotNull
	@OneToOne
	private Address address;
	
	@OneToMany()
	private Collection<BusinessHour> businessHours;
	
	@OneToMany(mappedBy="commercialGroup")
	private Collection<CommercialRoom> commercialRooms;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Collection<BusinessHour> getBusinessHours() {
		return businessHours;
	}

	public void setBusinessHours(Collection<BusinessHour> businessHours) {
		this.businessHours = businessHours;
	}

	public Collection<CommercialRoom> getCommercialRooms() {
		return commercialRooms;
	}

	public void setCommercialRooms(Collection<CommercialRoom> commercialRooms) {
		this.commercialRooms = commercialRooms;
	}
}
