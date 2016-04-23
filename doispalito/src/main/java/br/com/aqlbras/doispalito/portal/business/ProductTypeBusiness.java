package br.com.aqlbras.doispalito.portal.business;

import org.hibernate.Session;

import br.com.aqlbras.doispalito.portal.business.common.GenericBusiness;
import br.com.aqlbras.doispalito.portal.model.ProductType;
import br.com.aqlbras.doispalito.portal.repository.ProductTypeRepository;
import br.com.caelum.vraptor.ioc.Component;

@Component
public class ProductTypeBusiness extends GenericBusiness<ProductType> implements ProductTypeRepository 
{
	protected ProductTypeBusiness(Session session) 
	{
		super(session);
	}
}
