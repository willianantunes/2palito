package br.com.aqlbras.doispalito.portal.controller;

import br.com.aqlbras.doispalito.portal.annotation.Public;
import br.com.aqlbras.doispalito.portal.repository.ProductTypeRepository;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.core.Localization;
import br.com.caelum.vraptor.view.Results;

@Resource
public class ProductTypesController 
{
	// VRaptor
	private final Result result;
	private final Validator validator;
	private final Localization localization;
	// Repositories
	private final ProductTypeRepository productTypeRepository;
	
	public ProductTypesController(Result result, Validator validator,
			Localization localization,
			ProductTypeRepository productTypeRepository) 
	{
		this.result = result;
		this.validator = validator;
		this.localization = localization;
		this.productTypeRepository = productTypeRepository;
	}
	
	@Public
	@Get("/testeteste")
	public void list()
	{
		// TODO: Colocar para receber o ID do fornecedor e realizar o retorn somente dos tipos dele
		this.result.use(Results.jsonp()).withCallback("CallbackTeste")
		.from(this.productTypeRepository.list())
		.exclude("")
		.serialize();		
	}
}
