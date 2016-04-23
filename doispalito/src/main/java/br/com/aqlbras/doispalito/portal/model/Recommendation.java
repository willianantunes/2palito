package br.com.aqlbras.doispalito.portal.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.validator.constraints.Length;

import br.com.aqlbras.doispalito.portal.model.common.AbstractEntity;

@Entity
public class Recommendation extends AbstractEntity
{
	@Column(nullable = false, columnDefinition = "BIT DEFAULT 1", length = 1, insertable=false, updatable=true)
	private boolean liked;
	
	@Length(max=400)
	private String comment;
	
	@ManyToOne(optional=false)
	private Establishment establishment;
	
	@ManyToOne(optional=false, cascade={CascadeType.REFRESH, CascadeType.MERGE})
	private User user;
	
	@ManyToOne(optional=false)
	private Product product;
}

