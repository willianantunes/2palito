package br.com.aqlbras.catmovshop.mobile.android.integracao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import br.com.aqlbras.catmovshop.mobile.android.business.FornecedorBusiness;
import br.com.aqlbras.catmovshop.mobile.android.business.common.GenericBusiness;
import br.com.aqlbras.catmovshop.mobile.android.model.Fornecedor;
import br.com.aqlbras.catmovshop.mobile.android.model.Produto;

public class IntegracaoService {

	private GenericBusiness<Fornecedor> business = new FornecedorBusiness(
			"http://aqlbras.no-ip.biz:65002/catmovshop/restService/fornecedores");

	private HashMap<Fornecedor, List<Produto>> mapaProduto;

	public List<Produto> findProdutoByFornecedor(Fornecedor fornecedor) {

		if (mapaProduto == null) {
			mapaProduto = new HashMap<Fornecedor, List<Produto>>();
			loadMap();
		}

		return mapaProduto.get(fornecedor);
	}

	private void loadMap() {
		Fornecedor[] fornecedores = null;

		ArrayList<Produto> produtosUnicoFornecedor = new ArrayList<Produto>(50);

		try {

			fornecedores = business.list();

			for (Fornecedor fornecedor : fornecedores) {

				for (Produto produto : fornecedor.getProdutos()) {
					produto.setFornecedor(fornecedor);

					produtosUnicoFornecedor.add(produto);
				}

				mapaProduto.put(fornecedor, produtosUnicoFornecedor);

				produtosUnicoFornecedor = new ArrayList<Produto>(50);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
