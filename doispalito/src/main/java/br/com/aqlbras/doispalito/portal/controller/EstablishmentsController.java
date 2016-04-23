package br.com.aqlbras.doispalito.portal.controller;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;

import br.com.aqlbras.doispalito.portal.annotation.Public;
import br.com.aqlbras.doispalito.portal.component.UserSession;
import br.com.aqlbras.doispalito.portal.model.CustomerOrder;
import br.com.aqlbras.doispalito.portal.model.CustomerOrderStatus;
import br.com.aqlbras.doispalito.portal.model.Establishment;
import br.com.aqlbras.doispalito.portal.model.ProductItem;
import br.com.aqlbras.doispalito.portal.repository.CustomerOrderRepository;
import br.com.aqlbras.doispalito.portal.repository.EstablishmentRepository;
import br.com.caelum.vraptor.Consumes;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.core.Localization;
import br.com.caelum.vraptor.view.Results;

@Resource
public class EstablishmentsController 
{
	// VRaptor
	private final Result result;
	private final Validator validator;
	private final Localization localization;
	// Components
	private final UserSession userSession;
	// Repositories
	private final EstablishmentRepository establishmentRepository;
	private final CustomerOrderRepository customerOrderRepository;

	public EstablishmentsController(Result result, Validator validator,
			Localization localization, EstablishmentRepository establishmentRepository,
			CustomerOrderRepository customerOrderRepository, UserSession userSession) 
	{
		super();
		this.result = result;
		this.validator = validator;
		this.localization = localization;
		this.establishmentRepository = establishmentRepository;
		this.customerOrderRepository = customerOrderRepository;
		this.userSession = userSession;
	}
	
	@Get("/establishment/customerOrders/{id}")
	public CustomerOrder customerOrderDetails(Long id)
	{
		CustomerOrder customerOrder = this.customerOrderRepository.find(id);
		double totalPrice = 0;
		for (ProductItem pt : customerOrder.getProductItems()) 
		{
			totalPrice += pt.getPrice();
		}
		result.include("_totalPrice", totalPrice);
		return customerOrder;
	}
	
	@Get("/json/establishment/customerOrders/{customerOrderStatus}")
	public void customerOrders(CustomerOrderStatus customerOrderStatus)
	{
		List<CustomerOrder> customerOrders = (List<CustomerOrder>)this.
				customerOrderRepository.
				getCustomerOrdersByStatusAndEstablishmentId(
						this.userSession.getUser().getEstablishment().getId(), 
						customerOrderStatus
						);

		this.result.use(Results.json()).from(customerOrders).include("id").include("user")
			.exclude("user.email")
			.exclude("user.password")
			.serialize();		
	}

	@Get("/json/establishment/customerOrders/{customerOrderStatusOne}/{customerOrderStatusTwo}")
	public void customerOrders(CustomerOrderStatus customerOrderStatusOne, CustomerOrderStatus customerOrderStatusTwo)
	{
		List<CustomerOrder> customerOrders = (List<CustomerOrder>)this.
				customerOrderRepository.
				getCustomerOrdersByStatusAndEstablishmentId(
						this.userSession.getUser().getEstablishment().getId(), 
						customerOrderStatusOne, customerOrderStatusTwo
						);

		this.result.use(Results.json()).from(customerOrders).include("id").include("user")
			.exclude("user.email")
			.exclude("user.password")
			.serialize();		
	}	
	
	@Get("/json/establishment/customerOrders/{id}/changeTo/{customerOrderStatus}")
	public void changeStatusForCustomerOrder(Long id, CustomerOrderStatus customerOrderStatus)
	{
		CustomerOrder customerOrder = this.customerOrderRepository.find(id);
		customerOrder.setCustomerOrderStatus(customerOrderStatus);
		customerOrder.setLastUpdateDate(DateTime.now());
		
		this.result.use(Results.json()).from(customerOrder).include("id").include("user")
			.exclude("user.email")
			.exclude("user.password")
			.serialize();
	}	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Public
	@Get("/restService/establishment")
	public void getEstablishments()
	{				
		List<Establishment> establishments = (List<Establishment>) this.establishmentRepository.list();
		
		if(establishments != null)
		{
			// Gambiarra por causa do VRaptor
			// http://www.guj.com.br/1987-serializacao-com-resultjson-de-collectiont
			for(Establishment estab : establishments)
			{
				estab.setProducts(new ArrayList(estab.getProducts()));
			}
			
			this.result.use(Results.json()).withoutRoot().from(establishments)
			.include("brand")
			.include("commercialRoom")
			.include("commercialRoom.position")
			.serialize();
		}
		else
		{
			this.result.use(Results.status()).noContent();
		}		
	}	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Public
	@Post("/restService/establishment/products/singleProducts")
	@Consumes("application/json")
	public void getProductsByEstablishmentId(Establishment establishment)
	{
		Establishment estab = this.establishmentRepository.find(establishment.getId());
		
		if(estab != null)
		{			
			// Gambiarra por causa do VRaptor
			// http://www.guj.com.br/1987-serializacao-com-resultjson-de-collectiont
			estab.setProducts(new ArrayList(estab.getProducts()));
			
			this.result.use(Results.json()).withoutRoot().from(estab)
			.include("products")
			.serialize();
		}
		else
		{
			this.result.use(Results.status()).noContent();
		}
	}	
	
}
