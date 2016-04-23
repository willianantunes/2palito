package br.com.aqlbras.catmovshop.mobile.android.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import android.content.Context;
import android.util.Log;
import br.com.aqlbras.catmovshop.mobile.android.domain.Fornecedor;
import br.com.aqlbras.catmovshop.mobile.android.domain.Produto;
import br.com.aqlbras.catmovshop.mobile.android.util.HttpHelper;
import br.com.aqlbras.catmovshop.mobile.android.util.XMLUtils;

public class CardapioService {
	private static final String URL = "http://www.aqlbras.com.br/{chamada}.xml";
	private static final boolean LOG_ON = false;
	private static final String TAG = "CardapioService";

	// get Fornecedores
	public static List<Fornecedor> getFonecedores(Context context)
			throws IOException {
		String url = URL.replace("{chamada}", "fornecedores/listaFornecedores");
		String xml = HttpHelper.doGet(url, "UTF-8");
		List<Fornecedor> fornecedores = parserXML_Fornecedor(context, xml);
		return fornecedores;
	}

	// get Produtos
	public static Set<Produto> getProdutos(Context context,
			String nomeRestaurante) throws IOException {
		String url;

		if (nomeRestaurante == "") {
			url = URL.replace("{chamada}", "produtos/listaDeProdutos");
		} else {
			url = URL.replace("{chamada}", "produtos/" + nomeRestaurante
					+ "/listaDeProdutos");
		}

		String xml = HttpHelper.doGet(url, "UTF-8");
		Set<Produto> produtos = parserXML_Item(context, xml);
		return produtos;
	}

	// servico para buscar fornecedores
	private static List<Fornecedor> parserXML_Fornecedor(Context context,
			String xml) {
		List<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
		Element root = XMLUtils.getRoot(xml, "UTF-8");
		// Le todas as tags <fornecedor>
		List<Node> nodeFornecedores = XMLUtils.getChildren(root, "fornecedor");
		// Insere cada fornecedor na lista
		for (Node node : nodeFornecedores) {
			Fornecedor f = new Fornecedor();
			// L� as informa��es de cada fornecedor
			f.setId(XMLUtils.getText(node, "id"));
			f.setCnpj(XMLUtils.getText(node, "cnpj"));
			f.setDescricao(XMLUtils.getText(node, "descricao"));
			f.setLocalizacao(XMLUtils.getText(node, "localizacao"));
			f.setNumeroShop(XMLUtils.getText(node, "numeroShop"));
			f.setRazaoSocial(XMLUtils.getText(node, "razaoSocial"));
			f.setImagem(XMLUtils.getText(node, "imagem"));
			if (LOG_ON) {
				Log.d(TAG,
						"Fornecedor " + f.getRazaoSocial() + " > "
								+ f.getDescricao());
			}
			fornecedores.add(f);
		}
		if (LOG_ON) {
			Log.d(TAG, fornecedores.size() + " encontrados.");
		}
		return fornecedores;
	}

	// servico para buscar produtos
	private static Set<Produto> parserXML_Item(Context context, String xml) {
		Set<Produto> produtosSet = new HashSet<Produto>();

		Element root = XMLUtils.getRoot(xml, "UTF-8");
		// Le todas as tags <produto>
		List<Node> nodeProdutos = XMLUtils.getChildren(root, "produto");
		// Insere cada produto na lista
		for (Node node : nodeProdutos) {
			Produto produtoLidoXML = new Produto();
			// L� as informa��es de cada fornecedor
			produtoLidoXML.setId(XMLUtils.getText(node, "id"));
			produtoLidoXML.setNome(XMLUtils.getText(node, "nome"));
			produtoLidoXML.setDescricao(XMLUtils.getText(node, "descricao"));
			produtoLidoXML.setPreco(Double.parseDouble(XMLUtils.getText(node,
					"preco")));
			produtoLidoXML.imagem = XMLUtils.getText(node, "imagem");
			if (LOG_ON) {
				Log.d(TAG, "Produto " + produtoLidoXML.getNome() + " > "
						+ produtoLidoXML.getPreco());
			}
			produtosSet.add(produtoLidoXML);
		}
		if (LOG_ON) {
			Log.d(TAG, produtosSet.size() + " encontrados.");
		}
		return produtosSet;
	}

}
