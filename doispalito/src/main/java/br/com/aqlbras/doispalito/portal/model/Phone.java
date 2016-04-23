package br.com.aqlbras.doispalito.portal.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;

import org.hibernate.validator.constraints.Length;

import br.com.aqlbras.doispalito.portal.model.common.AbstractEntity;

@Entity
public class Phone extends AbstractEntity
{
	@Column(nullable=false)
	private String areaCode;
	
	@Column(nullable=false)
	private String number;
	
	@Length(min = 3, max = 100)
	private String contact;

	public String getAreaCode() 
	{
		return areaCode;
	}

	public void setAreaCode(String areaCode) 
	{
		this.areaCode = areaCode;
	}

	public String getNumber() 
	{
		return number;
	}

	public void setNumber(String number) 
	{
		this.number = number;
	}

	public String getContact() 
	{
		return contact;
	}

	public void setContact(String contact) 
	{
		this.contact = contact;
	}
}
