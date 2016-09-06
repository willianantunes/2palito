package br.com.aqlbras.catmovshop.mobile.android.integracao;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import android.content.Context;
import br.com.aqlbras.catmovshop.mobile.android.business.FornecedorBusiness;
import br.com.aqlbras.catmovshop.mobile.android.model.Fornecedor;

public class FornecedorIntegracao extends AbstractIntegracao<Fornecedor> {

	@Override
	public List<Fornecedor> getObjects(Context context, Object criterio)
			throws IOException {

		FornecedorBusiness fornecedorBusiness = new FornecedorBusiness(
				"http://aqlbras.no-ip.biz:65002/catmovshop/restService/fornecedores");

		List<Fornecedor> fornecedores = null;
		try {
			fornecedores = Arrays.asList(fornecedorBusiness.list());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fornecedores;
	}
}
