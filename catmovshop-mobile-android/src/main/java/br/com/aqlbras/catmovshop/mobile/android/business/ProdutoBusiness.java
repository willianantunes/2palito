package br.com.aqlbras.catmovshop.mobile.android.business;

import br.com.aqlbras.catmovshop.mobile.android.business.common.GenericBusiness;
import br.com.aqlbras.catmovshop.mobile.android.model.Produto;
import br.com.aqlbras.catmovshop.mobile.android.repository.ProdutoRepository;

public class ProdutoBusiness extends GenericBusiness<Produto> implements
		ProdutoRepository {

	public ProdutoBusiness(String baseURL) {
		super(baseURL);
	}

}
