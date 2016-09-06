package br.com.aqlbras.catmovshop.mobile.android.business;

import br.com.aqlbras.catmovshop.mobile.android.business.common.GenericBusiness;
import br.com.aqlbras.catmovshop.mobile.android.model.Pedido;
import br.com.aqlbras.catmovshop.mobile.android.repository.PedidoRepository;

public class PedidoBusiness extends GenericBusiness<Pedido> implements PedidoRepository{

	public PedidoBusiness(String baseURL) {
		super(baseURL);
	}

}