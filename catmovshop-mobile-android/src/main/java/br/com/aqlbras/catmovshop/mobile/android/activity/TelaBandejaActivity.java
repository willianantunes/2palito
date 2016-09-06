package br.com.aqlbras.catmovshop.mobile.android.activity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import br.com.aqlbras.catmovshop.mobile.android.Main;
import br.com.aqlbras.catmovshop.mobile.android.R;
import br.com.aqlbras.catmovshop.mobile.android.adapters.ItemProdutoAdapter;
import br.com.aqlbras.catmovshop.mobile.android.model.Bandeja;
import br.com.aqlbras.catmovshop.mobile.android.model.Fornecedor;
import br.com.aqlbras.catmovshop.mobile.android.model.ItemProduto;
import br.com.aqlbras.catmovshop.mobile.android.model.ObjetoTransferencia;

/**
 * @author Almeida
 * 
 */
public class TelaBandejaActivity extends AbstractListViewActivity<ItemProduto> {

	private Bandeja p;
	private Button btComprar;
	private ObjetoTransferencia obj;

	private class AcaoBotaoComprar implements OnClickListener {

		public void onClick(View v) {
//			Toast.makeText(TelaBandejaActivity.this, "FECHANDO O PEDIDO", 2).show();	
			p.realizarPedido();
		}
	}

	
	@Override
	protected void execucaoPosItemClick(AdapterView<?> parent, View view,
			int posicao, long id) {

//		ObjetoTransferencia obj = getObjetoTransferencia();

		obj.setUltimoItemEscolhido((ItemProduto) parent.getAdapter().getItem(posicao));
		obj.setProdutoEscolhido(obj.getUltimoItemEscolhido().getProduto());
		
		startActivityForResult(
				criarIntentObjetoTransferencia(AlertaActivity.class, obj), 1);

	}

	@Override
	protected void iniciaComponentesLayout() {

		btComprar = (Button) findViewById(R.id.btComprar);	

	}

	@Override
	protected void registraComponentesListeners() {
		super.registraComponentesListeners();

		btComprar.setOnClickListener(new AcaoBotaoComprar());
	}

	@Override
	protected void executaCarregamentoObjetosTela() {
		obj = getObjetoTransferencia();

		listView = (ListView) findViewById(R.id.listview);

		p = obj.getBandeja();

		Map<Fornecedor, Set<ItemProduto>> mapaItens = obj.getBandeja()
				.getMapaItensFornecedor();

		Set<Fornecedor> setChavesFornecedor = mapaItens.keySet();

		List<ItemProduto> produtos = new ArrayList<ItemProduto>();

		for (Fornecedor fornecedor : setChavesFornecedor) {

			for (ItemProduto itemProduto : mapaItens.get(fornecedor)) {
				produtos.add(itemProduto);
			}
		}

		listView.setAdapter(new ItemProdutoAdapter(produtos, activityThis));

	}

	@Override
	protected void setContentView() {
		setContentView(R.layout.tela_bandeja);
	}
	
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		ObjetoTransferencia obj = (ObjetoTransferencia) data.getExtras()
				.getSerializable(Main.nameObjetoTransferencia);
	
		
		startActivity(criarIntentObjetoTransferencia(TelaBandejaActivity.class, obj));

	}	

	public void onNewIntent(Intent newIntent){
		executaCarregamentoObjetosTela();
	}
}
