package br.com.aqlbras.doispalito.portal.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import br.com.aqlbras.doispalito.portal.model.common.AbstractEntity;

@Entity
/**
 * Prospecção: O atributo floor será 0 se não estiver em uma galeria ou na rua, por exemplo. O mesmo 
 * se aplica ao atributo standNumber
 * @author Willian Antunes / Bruno Alves
 * @version 1.0.0
 */
public class Position extends AbstractEntity 
{
	@NotNull
	private String floor;
	
	@NotNull
	private String standNumber;
	
	@OneToOne(optional=false)
	private CommercialRoom commercialRoom;
}
