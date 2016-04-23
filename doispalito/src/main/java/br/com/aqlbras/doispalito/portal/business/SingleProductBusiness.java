package br.com.aqlbras.doispalito.portal.business;

import org.hibernate.Session;

import br.com.aqlbras.doispalito.portal.business.common.GenericBusiness;
import br.com.aqlbras.doispalito.portal.model.SingleProduct;
import br.com.aqlbras.doispalito.portal.repository.SingleProductRepository;
import br.com.caelum.vraptor.ioc.Component;

@Component
public class SingleProductBusiness extends GenericBusiness<SingleProduct> implements SingleProductRepository 
{
	protected SingleProductBusiness(Session session) 
	{
		super(session);
	}
}
