package br.com.aqlbras.doispalito.portal.business;

import java.util.Collection;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;

import br.com.aqlbras.doispalito.portal.business.common.GenericBusiness;
import br.com.aqlbras.doispalito.portal.model.CustomerOrder;
import br.com.aqlbras.doispalito.portal.model.CustomerOrderStatus;
import br.com.aqlbras.doispalito.portal.repository.CustomerOrderRepository;
import br.com.caelum.vraptor.ioc.Component;

@Component
public class CustomerOrderBusiness extends GenericBusiness<CustomerOrder> implements CustomerOrderRepository 
{

	protected CustomerOrderBusiness(Session session) 
	{
		super(session);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<CustomerOrder> getCustomerOrdersByStatusAndEstablishmentId(
			Long id, CustomerOrderStatus... customerOrderStatus) 
	{
		if(customerOrderStatus.length == 1)
		{
			return (Collection<CustomerOrder>)super.session.createCriteria(CustomerOrder.class)
					.add(Restrictions.eq("customerOrderStatus", customerOrderStatus[0]))
					.add(Restrictions.eq("establishment.id", id))
					.list();			
		}
		else
		{
			Criteria c = super.session.createCriteria(CustomerOrder.class);
			Disjunction dis = Restrictions.disjunction();
			for (int i = 0; i < customerOrderStatus.length; i++) 
			{
				dis.add(Restrictions.eq("customerOrderStatus", customerOrderStatus[i]));			
			}
			c.add(dis);
			c.add(Restrictions.eq("establishment.id", id));
			return (Collection<CustomerOrder>)c.list();
		}		
	}

}
