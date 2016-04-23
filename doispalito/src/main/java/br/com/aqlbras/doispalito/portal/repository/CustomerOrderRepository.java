package br.com.aqlbras.doispalito.portal.repository;

import java.util.Collection;

import br.com.aqlbras.doispalito.portal.model.CustomerOrder;
import br.com.aqlbras.doispalito.portal.model.CustomerOrderStatus;
import br.com.aqlbras.doispalito.portal.repository.common.GenericRepository;

public interface CustomerOrderRepository extends GenericRepository<CustomerOrder> 
{
	// http://stackoverflow.com/questions/965690/java-optional-parameters
	Collection<CustomerOrder> getCustomerOrdersByStatusAndEstablishmentId(Long id, CustomerOrderStatus... customerOrderStatus);
}
