package br.com.aqlbras.doispalito.portal.business;

import org.hibernate.Session;

import br.com.aqlbras.doispalito.portal.business.common.GenericBusiness;
import br.com.aqlbras.doispalito.portal.model.Shopping;
import br.com.aqlbras.doispalito.portal.repository.ShoppingRepository;
import br.com.caelum.vraptor.ioc.Component;

@Component
public class ShoppingBusiness extends GenericBusiness<Shopping> implements ShoppingRepository 
{
	protected ShoppingBusiness(Session session) 
	{
		super(session);
	}
}
