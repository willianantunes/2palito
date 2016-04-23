package br.com.aqlbras.doispalito.portal.controller;
 
import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;

import com.google.common.collect.Lists;

import br.com.aqlbras.doispalito.portal.annotation.Public;
import br.com.aqlbras.doispalito.portal.component.UserSession;
import br.com.aqlbras.doispalito.portal.model.ComboProduct;
import br.com.aqlbras.doispalito.portal.model.Establishment;
import br.com.aqlbras.doispalito.portal.model.Product;
import br.com.aqlbras.doispalito.portal.model.SingleProduct;
import br.com.aqlbras.doispalito.portal.repository.ComboProductRepository;
import br.com.aqlbras.doispalito.portal.repository.EstablishmentRepository;
import br.com.aqlbras.doispalito.portal.repository.ProductRepository;
import br.com.aqlbras.doispalito.portal.repository.SingleProductRepository;
import br.com.caelum.vraptor.Consumes;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.core.Localization;
import br.com.caelum.vraptor.view.Results;

@Resource
public class ProductsController 
{
	// VRaptor
	private final Result result;
	private final Validator validator;
	private final Localization localization;
	// Component
	private final UserSession userSession;
	// Repositories
	private final SingleProductRepository singleProductRepository;
	private final EstablishmentRepository establishmentRepository;
	private final ComboProductRepository comboProductRepository;
	private final ProductRepository productRepository;
	
	public ProductsController(Result result, Validator validator,
			Localization localization, UserSession userSession,
			SingleProductRepository singleProductRepository,
			EstablishmentRepository establishmentRepository,
			ComboProductRepository comboProductRepository,
			ProductRepository productRepository) 
	{
		this.result = result;
		this.validator = validator;
		this.localization = localization;
		this.userSession = userSession;
		this.singleProductRepository = singleProductRepository;
		this.establishmentRepository = establishmentRepository;
		this.comboProductRepository = comboProductRepository;
		this.productRepository = productRepository;
	}
	
	@Public
	@Get("/products")
	public List<Product> list()
	{
		return Lists.newArrayList(this.productRepository.list());
	}
	
	@Get("/products/{id}")
	public Product view(Long id)
	{
		return this.productRepository.find(id);
	}
	
	@Get("/products/add")
	public void create()
	{
		
	}
	
	@Post("/products/add")
	public void create(Product product)
	{
		product.setRegisterDate(DateTime.now());
		product.setEstablishment(this.userSession.getUser().getEstablishment());
		
		// TODO: Colocar validação
		
		if(product instanceof SingleProduct)
		{
			this.singleProductRepository.save((SingleProduct)product);
		}
		else
		{
			this.comboProductRepository.save((ComboProduct)product);
		}
				
		result.include("mensagem", this.localization.getMessage("mensagem.crudProdutoAdicionado"));
		result.redirectTo(this).list();		
	}		
	
	@Put("/products")
	public void update(Product product)
	{
		// TODO: Implementar UPDATE do produto
	}
	
	@Get("/products/delete/{id}")
	public void delete(Long id)
	{
		// TODO: Colocar uma mensagem retratando que, caso tenha um relacionamento, se o usuário deseja realmente excluir tudo
		this.singleProductRepository.remove(new SingleProduct(id));
		result.include("mensagem", this.localization.getMessage("mensagem.crudProdutoExcluido"));
		result.redirectTo(this).list();
	}
	
	//////////////////////////////////////////////////////////////////////////////////
	// Métodos para o WEB SERVICES
	//////////////////////////////////////////////////////////////////////////////////		

	@Public
	@Get("/restService/products/singleProducts")
	public void getProducts()
	{				
		List<SingleProduct> singleProducts = Lists.newArrayList(this.singleProductRepository.list());
		
		if(singleProducts != null)
		{
			// Gambiarra por causa do VRaptor
			// http://www.guj.com.br/1987-serializacao-com-resultjson-de-collectiont
			for(SingleProduct sp : singleProducts)
			{
				sp.setProductTypes(Lists.newArrayList(sp.getProductTypes()));
			}
			
			this.result.use(Results.json()).withoutRoot().from(singleProducts)
			.include("productTypes")
			.include("establishment")
			.include("establishment.brand")
			.serialize();
		}
		else
		{
			this.result.use(Results.status()).noContent();
		}		
	}		
	
}
