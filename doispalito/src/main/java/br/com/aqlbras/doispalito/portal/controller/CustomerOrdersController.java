package br.com.aqlbras.doispalito.portal.controller;

import br.com.aqlbras.doispalito.portal.annotation.Public;
import br.com.aqlbras.doispalito.portal.model.CustomerOrder;
import br.com.aqlbras.doispalito.portal.repository.CustomerOrderRepository;
import br.com.caelum.vraptor.Consumes;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.core.Localization;
import br.com.caelum.vraptor.view.Results;

@Resource
public class CustomerOrdersController 
{
	// VRaptor
	private final Result result;
	private final Validator validator;
	private final Localization localization;	
	// Repositories
	private final CustomerOrderRepository customerOrderRepository;
	
	public CustomerOrdersController(Result result, Validator validator,
			Localization localization,
			CustomerOrderRepository customerOrderRepository) 
	{
		this.result = result;
		this.validator = validator;
		this.localization = localization;
		this.customerOrderRepository = customerOrderRepository;
	}
	
	@Public
	@Post("/restService/customerOrder")
	@Consumes("application/json")
	public void registerCustomerOrder(CustomerOrder customerOrder)
	{
		this.customerOrderRepository.save(customerOrder);
		
		System.out.print("Vazio? " + customerOrder.getProductItems().isEmpty());
		
		this.result.use(Results.status()).created();
	}
}
