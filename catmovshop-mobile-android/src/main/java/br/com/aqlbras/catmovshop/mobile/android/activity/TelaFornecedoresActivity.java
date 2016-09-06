package br.com.aqlbras.catmovshop.mobile.android.activity;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import br.com.aqlbras.catmovshop.mobile.android.R;
import br.com.aqlbras.catmovshop.mobile.android.adapters.FornecedorAdapter;
import br.com.aqlbras.catmovshop.mobile.android.integracao.AbstractIntegracao;
import br.com.aqlbras.catmovshop.mobile.android.integracao.FornecedorIntegracao;
import br.com.aqlbras.catmovshop.mobile.android.model.Fornecedor;
import br.com.aqlbras.catmovshop.mobile.android.model.ObjetoTransferencia;

/**
 * @author Wellington Almeida
 * 
 */
public class TelaFornecedoresActivity extends AbstractListViewActivity<Fornecedor> 
{

	protected class BuscaFornecedores extends BuscaTask 
	{

		public BuscaFornecedores(Context context, AbstractIntegracao<Fornecedor> integracao, String criterio) 
		{
			super(context, integracao, criterio);
		}

		@Override
		protected void onPostExecute(List<Fornecedor> objetos) 
		{
			listView.setAdapter(new FornecedorAdapter(objetos, activityThis));
		}
	}

	@Override
	protected void setContentView() {
		setContentView(R.layout.tela_restaurantes);
	}

	@Override
	protected void iniciaComponentesLayout() {
		listView = (ListView) findViewById(R.id.lvRestaurantes);
	}

	@Override
	protected void executaCarregamentoObjetosTela() {
		new BuscaFornecedores(activityThis, new FornecedorIntegracao(), null)
				.execute();
	}

	@Override
	protected void execucaoPosItemClick(AdapterView<?> parent, View view, int posicao, long id) 
	{
		Fornecedor f = (Fornecedor) parent.getAdapter().getItem(posicao);

		ObjetoTransferencia objTransferencia = getObjetoTransferencia();

		objTransferencia.setFornecedor(f);

		startActivity(criarIntentObjetoTransferencia(TelaItensActivity.class,
				objTransferencia));

	}
}
