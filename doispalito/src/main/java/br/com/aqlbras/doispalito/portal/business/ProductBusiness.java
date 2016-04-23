package br.com.aqlbras.doispalito.portal.business;

import org.hibernate.Session;

import br.com.aqlbras.doispalito.portal.business.common.GenericBusiness;
import br.com.aqlbras.doispalito.portal.model.Product;
import br.com.aqlbras.doispalito.portal.repository.ProductRepository;
import br.com.caelum.vraptor.ioc.Component;

@Component
public class ProductBusiness extends GenericBusiness<Product> implements ProductRepository
{
	protected ProductBusiness(Session session) 
	{
		super(session);
	}
}
