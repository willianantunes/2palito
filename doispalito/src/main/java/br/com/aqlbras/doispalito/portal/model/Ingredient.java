package br.com.aqlbras.doispalito.portal.model;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.aqlbras.doispalito.portal.model.common.AbstractEntity;

@Entity
public class Ingredient extends AbstractEntity 
{
	@NotNull
	@Length(max=70)
	private String name;
}
