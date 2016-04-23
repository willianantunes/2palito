package br.com.aqlbras.doispalito.portal.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.aqlbras.doispalito.portal.model.common.AbstractEntity;

@Entity
public class Brand extends AbstractEntity
{
	@Column(nullable=false)
	@Length(min = 3, max = 100)	
	private String name;
	
	@NotNull
	@Length(max=400)
	private String description;
	
	@NotNull
	@Length(max=100)
	private String imageLink;
	
	@Length(max=100)
	private String siteWebPortal;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="brand")
	private Collection<Establishment> establishments;
}
