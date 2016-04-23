package br.com.aqlbras.doispalito.portal.controller;

import java.util.ArrayList;
import java.util.List;

import br.com.aqlbras.doispalito.portal.annotation.Public;
import br.com.aqlbras.doispalito.portal.model.Shopping;
import br.com.aqlbras.doispalito.portal.model.SingleProduct;
import br.com.aqlbras.doispalito.portal.repository.ShoppingRepository;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.core.Localization;
import br.com.caelum.vraptor.view.Results;

@Resource
public class ShoppingsController 
{
	// VRaptor
	private final Result result;
	private final Validator validator;
	private final Localization localization;	
	// Repositories
	private final ShoppingRepository shoppingRepository;
	public ShoppingsController(Result result, Validator validator,
			Localization localization, ShoppingRepository shoppingRepository) 
	{
		this.result = result;
		this.validator = validator;
		this.localization = localization;
		this.shoppingRepository = shoppingRepository;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Public
	@Get("/restService/shoppings")
	public void getShoppings()
	{				
		List<Shopping> shoppings = (List<Shopping>)this.shoppingRepository.list();
		
		if(shoppings != null)
		{
			// Gambiarra por causa do VRaptor
			// http://www.guj.com.br/1987-serializacao-com-resultjson-de-collectiont
			for(Shopping sh : shoppings)
			{
				//sh.setBusinessHours(new ArrayList(sh.getBusinessHours()));
				sh.setCommercialRooms(new ArrayList(sh.getCommercialRooms()));
			}
						
			this.result.use(Results.json()).withoutRoot().from(shoppings)
			.include("commercialRooms")
			.include("commercialRooms.position")
			.include("commercialRooms.establishment")
			.include("commercialRooms.establishment.brand")
			.serialize();
		}
		else
		{
			this.result.use(Results.status()).noContent();
		}
	}	
}
