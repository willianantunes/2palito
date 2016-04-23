package br.com.aqlbras.doispalito.portal.business;

import org.hibernate.Session;

import br.com.aqlbras.doispalito.portal.business.common.GenericBusiness;
import br.com.aqlbras.doispalito.portal.model.Establishment;
import br.com.aqlbras.doispalito.portal.repository.EstablishmentRepository;
import br.com.caelum.vraptor.ioc.Component;

@Component
public class EstablishmentBusiness extends GenericBusiness<Establishment> implements EstablishmentRepository 
{

	protected EstablishmentBusiness(Session session) 
	{
		super(session);
	}

}
