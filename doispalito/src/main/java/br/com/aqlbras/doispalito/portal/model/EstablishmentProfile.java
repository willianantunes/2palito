package br.com.aqlbras.doispalito.portal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

import br.com.aqlbras.doispalito.portal.model.common.AbstractEntity;

@Entity
public class EstablishmentProfile extends AbstractEntity
{
	@Column(nullable = false, columnDefinition = "BIT DEFAULT 0", length = 1)
	private boolean attendCounter;
	
	@Column(nullable = false, columnDefinition="TINYINT(1) DEFAULT 5")
	private int timeOutTreatment;
	
	@OneToOne(optional=false, mappedBy="establishmentProfile")
	private Establishment supplier;
}
