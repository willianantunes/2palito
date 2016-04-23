package br.com.aqlbras.doispalito.portal.business;

import org.hibernate.Session;

import br.com.aqlbras.doispalito.portal.business.common.GenericBusiness;
import br.com.aqlbras.doispalito.portal.model.ComboProduct;
import br.com.aqlbras.doispalito.portal.repository.ComboProductRepository;
import br.com.caelum.vraptor.ioc.Component;

@Component
public class ComboProductBusiness extends GenericBusiness<ComboProduct> implements ComboProductRepository 
{
	protected ComboProductBusiness(Session session) 
	{
		super(session);
	}
}
