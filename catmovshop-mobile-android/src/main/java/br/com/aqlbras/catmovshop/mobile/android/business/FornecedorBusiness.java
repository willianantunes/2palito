package br.com.aqlbras.catmovshop.mobile.android.business;

import br.com.aqlbras.catmovshop.mobile.android.business.common.GenericBusiness;
import br.com.aqlbras.catmovshop.mobile.android.model.Fornecedor;
import br.com.aqlbras.catmovshop.mobile.android.repository.FornecedorRepository;

public class FornecedorBusiness extends GenericBusiness<Fornecedor> implements FornecedorRepository 
{

	public FornecedorBusiness(String baseURL) {
		// We must set this using config file or somoething like that - Antunes
		super(baseURL);
	}


}
