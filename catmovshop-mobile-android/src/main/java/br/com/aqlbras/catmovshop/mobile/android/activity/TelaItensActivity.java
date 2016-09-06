package br.com.aqlbras.catmovshop.mobile.android.activity;

import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import br.com.aqlbras.catmovshop.mobile.android.Main;
import br.com.aqlbras.catmovshop.mobile.android.R;
import br.com.aqlbras.catmovshop.mobile.android.adapters.ProdutoAdapter;
import br.com.aqlbras.catmovshop.mobile.android.integracao.AbstractIntegracao;
import br.com.aqlbras.catmovshop.mobile.android.integracao.ProdutoIntegracao;
import br.com.aqlbras.catmovshop.mobile.android.model.ObjetoTransferencia;
import br.com.aqlbras.catmovshop.mobile.android.model.Produto;

public class TelaItensActivity extends AbstractListViewActivity<Produto> {

	protected class BuscaProdutos extends BuscaTask {

		public BuscaProdutos(Context context,
				AbstractIntegracao<Produto> integracao, Object criterio) {
			super(context, integracao, criterio);
		}

		@Override
		protected void onPostExecute(List<Produto> produtos) {
			listView.setAdapter(new ProdutoAdapter(produtos, activityThis));
		}
	}

	@Override
	protected void iniciaComponentesLayout() {
		listView = (ListView) findViewById(R.id.lvItens);

	}

	@Override
	protected void executaCarregamentoObjetosTela() {

		new BuscaProdutos(activityThis, new ProdutoIntegracao(),
				getObjetoTransferencia().getFornecedor())
				.execute();

	}

	@Override
	protected void setContentView() {
		setContentView(R.layout.tela_itens);
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		ObjetoTransferencia obj = (ObjetoTransferencia) data.getExtras()
				.getSerializable(Main.nameObjetoTransferencia);

		startActivity(criarIntentObjetoTransferencia(TelaBandejaActivity.class,
				obj));

	}

	@Override
	protected void execucaoPosItemClick(AdapterView<?> parent, View view,
			int posicao, long id) {

		ObjetoTransferencia obj = getObjetoTransferencia();

		obj.setProdutoEscolhido((Produto) parent.getAdapter().getItem(posicao));

		startActivityForResult(
				criarIntentObjetoTransferencia(AlertaActivity.class, obj), 1);
	}
}
