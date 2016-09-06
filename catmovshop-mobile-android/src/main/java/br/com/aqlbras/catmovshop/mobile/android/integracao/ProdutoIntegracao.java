package br.com.aqlbras.catmovshop.mobile.android.integracao;

import java.io.IOException;
import java.util.List;

import android.content.Context;
import br.com.aqlbras.catmovshop.mobile.android.model.Fornecedor;
import br.com.aqlbras.catmovshop.mobile.android.model.Produto;

public class ProdutoIntegracao extends AbstractIntegracao<Produto> {

	private List<Produto> getProdutos(Context context, Object criterio)
			throws IOException {

		// if (nomeRestaurante == "") {
		// url = URL.replace("{chamada}", "produtos/listaDeProdutos");
		// } else {
		// url = URL.replace("{chamada}", "produtos/" + nomeRestaurante
		// + "/listaDeProdutos");
		// }

		// ProdutoBusiness produtoBusiness = new ProdutoBusiness(
		// "aqlbras.no-ip.biz:65002/catmovshop/restService/produtos");

		List<Produto> produtos = null;

		try {

			produtos = integracao
					.findProdutoByFornecedor((Fornecedor) criterio);

			// Arrays.asList(produtoBusiness.list());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return produtos;
	}

	@Override
	public List<Produto> getObjects(Context context, Object criterio)
			throws IOException {
		return getProdutos(context, criterio);
	}
}
