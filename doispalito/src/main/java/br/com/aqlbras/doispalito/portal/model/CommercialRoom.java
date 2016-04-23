package br.com.aqlbras.doispalito.portal.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import br.com.aqlbras.doispalito.portal.model.common.AbstractEntity;

@Entity
public class CommercialRoom extends AbstractEntity
{
	@OneToOne(mappedBy="commercialRoom", optional=false)
	private Position position;
	
	@ManyToOne(optional=false)
	private CommercialGroup commercialGroup;
	
	@OneToOne(mappedBy="commercialRoom")
	private Establishment establishment;

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public CommercialGroup getCommercialGroup() {
		return commercialGroup;
	}

	public void setCommercialGroup(CommercialGroup commercialGroup) {
		this.commercialGroup = commercialGroup;
	}

	public Establishment getEstablishment() {
		return establishment;
	}

	public void setEstablishment(Establishment establishment) {
		this.establishment = establishment;
	}
}
